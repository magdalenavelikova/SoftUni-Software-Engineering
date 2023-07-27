package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskWrapperDto;
import softuni.exam.models.entity.Task;
import softuni.exam.models.enums.CarType;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_XML;


@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = RESOURCES_FILE_PATH_XML + "tasks.xml";

    private final TasksRepository tasksRepository;
    private final MechanicsRepository mechanicsRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final PartsRepository partsRepository;
    private final CarsRepository carsRepository;
    private final ValidationUtil validationUtil;

    public TasksServiceImpl(TasksRepository tasksRepository,
                            MechanicsRepository mechanicsRepository,
                            ModelMapper mapper,
                            XmlParser xmlParser,
                            PartsRepository partsRepository,
                            CarsRepository carsRepository,
                            ValidationUtil validationUtil) {
        this.tasksRepository = tasksRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.partsRepository = partsRepository;
        this.carsRepository = carsRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return tasksRepository.count() != 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        if (tasksRepository.count() == 0) {
            TaskWrapperDto tasksWrapperDto = xmlParser
                    .fromFile(TASKS_FILE_PATH, TaskWrapperDto.class);
            tasksWrapperDto.getTasks().stream()
                    .filter(tasksSeedDto -> {
                                boolean isValid = validationUtil.isValid(tasksSeedDto);
                                boolean isValidCar = carsRepository.findById(tasksSeedDto.getCar().getId()).isPresent();
                                boolean isValidMechanic =
                                        mechanicsRepository.findFirstByFirstName(tasksSeedDto.getMechanic().getFirstName())
                                                .isPresent();
                                if (isValid && isValidMechanic && isValidCar) {
                                    stringBuilder.append(String.format("Successfully imported task %s",
                                                    tasksSeedDto.getPrice().setScale(2)))
                                            .append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid task").append(System.lineSeparator());
                                }
                                return (isValid && isValidMechanic && isValidCar);
                            }
                    )
                    .map(tasksSeedDto -> {
                                Task task = mapper.map(tasksSeedDto, Task.class);
                                task.setMechanic(mechanicsRepository.findFirstByFirstName(
                                                tasksSeedDto.
                                                        getMechanic().
                                                        getFirstName()).
                                        get());

                                task.setCars(carsRepository.findById(tasksSeedDto.getCar().getId()).get());
                                task.setParts(partsRepository.findById(tasksSeedDto.getPart().getId()).get());

                                return task;
                            }
                    )
                    .forEach(tasksRepository::save);
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
//•	Extract from the database, the car's make, car's model, mechanic's first name, mechanic's last name, task id, engine, task price (to second digit after decimal point) of the task.
//•	Filter only coupe cars and order them by the price in descending order.
//•	Return the information in this format:
//•	"Car {carMake} {carModel} with {kilometers}km
//                                    -Mechanic: {firstName} {lastName} - task №{taskId}:¬¬
//                                    --Engine: {engine}
//                                    ---Price: {taskPrice}$
        StringBuilder sb = new StringBuilder();

        tasksRepository.findAllByCars_CarTypeOrderByPriceDesc(CarType.coupe).stream().forEach(task -> {
            sb.append(String.format("Car %s %s with %dkm",
                    task.getCars().getCarMake(),
                    task.getCars().getCarModel(),
                    task.getCars().getKilometers())).append(System.lineSeparator());
            sb.append(String.format("-Mechanic: %s %s - task №%d:",
                    task.getMechanic().getFirstName(),
                    task.getMechanic().getLastName(),
                    task.getId())).append(System.lineSeparator());
            sb.append(String.format(" --Engine: %.1f",
                    task.getCars().getEngine())).append(System.lineSeparator());
            sb.append(String.format("---Price: %.2f$",
                    task.getPrice())).append(System.lineSeparator());


        });


        return sb.toString().trim();
    }
}
