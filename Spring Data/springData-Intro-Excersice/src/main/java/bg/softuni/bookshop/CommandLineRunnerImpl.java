package bg.softuni.bookshop;

import bg.softuni.bookshop.models.AgeRestriction;
import bg.softuni.bookshop.models.EditionType;
import bg.softuni.bookshop.services.AuthorService;
import bg.softuni.bookshop.services.BookService;
import bg.softuni.bookshop.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;


    public CommandLineRunnerImpl(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose task /1-14/: ");
        int task = Integer.parseInt(bufferedReader.readLine());
        while (task != 0) {

            switch (task) {
                case 1 -> {
                    System.out.println("1. Books Titles by Age Restriction");
                    System.out.println("Enter Age Restriction (MINOR, TEEN, ADULT): ");
                    String ageRestrictionStr = bufferedReader.readLine();
                    try {
                        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionStr.toUpperCase());
                        printBooksTitlesByAgeRestriction(ageRestriction);
                    } catch (Exception e) {
                        System.out.println("Invalid Type of Age Restriction");
                    }
                }
                case 2 -> {
                    System.out.println("2. Golden Books");
                    int copies = 5000;
                    printGoldenBooks(EditionType.GOLD, copies);

                }
                case 3 -> {
                    System.out.println("3. Books by Price");
                    BigDecimal lower = new BigDecimal(5);
                    BigDecimal higher = new BigDecimal(40);
                    printBooksByPrice(lower, higher);
                }
                case 4 -> {
                    System.out.println("4. Not Released Books");
                    System.out.println("Enter a year:");
                    int year = Integer.parseInt(bufferedReader.readLine());
                    LocalDate start = LocalDate.of(year, 1, 1);
                    LocalDate end = LocalDate.of(year, 12, 31);
                    printNotReleasedBooks(start, end);
                }
                case 5 -> {
                    System.out.println("5. Books Released Before Date");
                    System.out.println("Enter a date (in format dd-MM-yyyy): ");
                    LocalDate date = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    printBooksReleasedBeforeDate(date);

                }
                case 6 -> {
                    System.out.println("6. Authors Search");
                    System.out.println("Enter a string: ");
                    String endsWith = bufferedReader.readLine();
                    printAuthorsName(endsWith);

                }
                case 7 -> {
                    System.out.println("7. Books Search");
                    System.out.println("Input Ingredients: ");
                    System.out.println("Enter a string: ");
                    String contains = bufferedReader.readLine();
                    printBooksTitle(contains);

                }
                case 8 -> {
                    System.out.println("8. Book Titles Search");
                    System.out.println("Enter a string: ");
                    String startsWith = bufferedReader.readLine();
                    printBookTitlesWithAuthor(startsWith);
                }
                case 9 -> {
                    System.out.println("9. Count Books");
                    System.out.println("Enter a title length: ");
                    int length = Integer.parseInt(bufferedReader.readLine());
                    printCountOfBook(length);

                }
                case 10 -> {
                    System.out.println("10. Total Book Copies");
                    printTotalBookCopies();
                }
                case 11 -> {
                    System.out.println("11. Reduced Book");
                    System.out.println("Enter a title: ");
                    String title = bufferedReader.readLine();
                    printReducedBook(title);
                }
                case 12 -> {
                    System.out.println("12. *Increase Book Copies");
                    System.out.println("Enter a date (in format dd MMM yyyy): ");
                    LocalDate dateAfter = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd MMM yyyy"));
                    System.out.println("Enter increased with: ");
                    int addCopies = Integer.parseInt(bufferedReader.readLine());
                    int affectedRows = this.bookService.updateBookCopies(dateAfter, addCopies);
                    System.out.println(addCopies * affectedRows);
                }
                case 13 -> {
                    System.out.println("13.* Remove Books");
                    System.out.println("Enter a number for copies lower than: ");
                    int copies = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Number of books that were deleted is: " + this.bookService.deleteBooks(copies));
                }
                case 14->{
                    System.out.println("14. * Stored Procedure");
                    System.out.println("Enter authors first name: ");
                    String firstName = bufferedReader.readLine();
                    System.out.println("Enter authors last name: ");
                    String lastName = bufferedReader.readLine();
                    int count=this.bookService.storedProcedureCall(firstName,lastName);
                    System.out.printf("%s %s has written %d books",firstName,lastName,count);
                }

                default -> throw new IllegalStateException("No such task: " + task);
            }
            System.out.println();
            System.out.println("Choose task /1-14/: ");
            System.out.println("For exit press 0: ");
            task = Integer.parseInt(bufferedReader.readLine());

        }

    }

    private void printReducedBook(String title) {
        this.bookService.findBook(title)
                .forEach(System.out::println);
    }

    private void printTotalBookCopies() {
        authorService.findTotalBookCopies()
                .forEach(System.out::println);
    }

    private void printCountOfBook(int length) {
        int count = this.bookService.countOfBooks(length);
        System.out.printf("There are %d books with longer title than %d symbols", count, length);
    }

    private void printBookTitlesWithAuthor(String startsWith) {
        this.bookService.findBookTitlesWithAuthor(startsWith)
                .forEach(System.out::println);
    }

    private void printBooksTitle(String contains) {
        this.bookService.findBooksTitle(contains)
                .forEach(System.out::println);
    }

    private void printAuthorsName(String endsWith) {
        this.authorService.findAuthorsWithFirstName(endsWith)
                .forEach(System.out::println);
    }

    private void printBooksReleasedBeforeDate(LocalDate date) {
        this.bookService.findBooksReleasedBeforeDate(date)
                .forEach(System.out::println);
    }

    private void printNotReleasedBooks(LocalDate start, LocalDate end) {
        this.bookService.findNotReleasedBooks(start, end)
                .forEach(System.out::println);
    }

    private void printBooksByPrice(BigDecimal lower, BigDecimal higher) {
        this.bookService.findBooksByPrice(lower, higher)
                .forEach(System.out::println);
    }

    private void printGoldenBooks(EditionType gold, int copies) {
        this.bookService.findGoldenBooks(gold, copies)
                .forEach(System.out::println);
    }

    private void printBooksTitlesByAgeRestriction(AgeRestriction ageRestriction) {
        this.bookService.findBooksTitlesByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }


    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
