package bg.softuni.productshop.service;


import bg.softuni.productshop.excetption.UnableToConvertException;
import bg.softuni.productshop.model.dto.*;
import bg.softuni.productshop.model.entity.Product;
import bg.softuni.productshop.model.entity.User;
import bg.softuni.productshop.repository.UserRepository;
import bg.softuni.productshop.util.FormatConverter;
import bg.softuni.productshop.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bg.softuni.productshop.constans.GlobalConstants.RESOURCES_FILE_PATH;
import static java.util.Arrays.stream;


@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper mapper;
    private static final String FILENAME = "users.";
    private final UserRepository userRepository;

    private final ValidationUtil validationUtil;


    public UserServiceImpl(ModelMapper mapper,
                           UserRepository userRepository,  ValidationUtil validationUtil) {
        this.mapper = mapper;
        this.userRepository = userRepository;

        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsersFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (userRepository.count() == 0) {
            seedToDb(stream(converter.deserializeFromFile(RESOURCES_FILE_PATH + FILENAME + typeFormat,
                    UserSeedDto[].class)

            )
                    .toList());
        }
    }
    @Override
    public void seedUsersFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (userRepository.count() == 0) {
            UsersSeedDto usersSeedDto = converter.deserializeFromFile(RESOURCES_FILE_PATH + FILENAME + typeFormat,
                    UsersSeedDto.class);

                    seedToDb(usersSeedDto.getUsers());
        }
    }


    private void seedToDb(List<UserSeedDto> usersSeedDto) {
        usersSeedDto.stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> mapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, userRepository.count() + 1);

        return userRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<UserWithSoldProductsDto> soldProduct() {

        return userRepository.findAllBySoldProducts().stream()
                .map(u -> {
                            UserWithSoldProductsDto user = mapper.map(u, UserWithSoldProductsDto.class);
                            Set<SoldProductsDto> sold = user.getSoldProducts()
                                    .stream().filter(p -> p.getBuyerLastName() != null)
                                    .collect(Collectors.toSet());
                            user.setSoldProducts(sold);
                            return user;
                        }
                )
                .collect(Collectors.toList());


    }
    @Override
    public UserWithSoldProductsDtoXML soldProductForXML() {
        UserWithSoldProductsDtoXML user=new UserWithSoldProductsDtoXML();
        user.setUsers(soldProduct());
        return user;
    }


    @Override
    public UsersAndProductsDto usersAndProducts() {


        List<User> users = userRepository.usersAndProducts().orElseThrow(NoSuchElementException::new);


        List<UsersSoldProductsWithAgeDto> usersSoldProductsList = users.stream()
                .map(u -> {
                    UsersSoldProductsWithAgeDto user = mapper.map(u, UsersSoldProductsWithAgeDto.class);

                    user.getProducts().setCount(u.getSoldProducts().size());
//                    List<ProductNameAndPriceDto> products = u.getSoldProducts().stream()
//                            .map(product -> mapper.map(product, ProductNameAndPriceDto.class))
//                            .collect(Collectors.toList());
//
//                    user.getProducts().setSoldProducts(products);
                    return user;
                })
                .collect(Collectors.toList());
        UsersAndProductsDto usersAndProductsDto = new UsersAndProductsDto(usersSoldProductsList);

        return usersAndProductsDto;
    }
}
