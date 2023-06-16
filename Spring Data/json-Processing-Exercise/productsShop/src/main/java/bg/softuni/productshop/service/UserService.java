package bg.softuni.productshop.service;



import bg.softuni.productshop.excetption.UnableToConvertException;
import bg.softuni.productshop.model.dto.UserWithSoldProductsDto;
import bg.softuni.productshop.model.dto.UserWithSoldProductsDtoXML;
import bg.softuni.productshop.model.dto.UsersAndProductsDto;
import bg.softuni.productshop.model.entity.User;
import bg.softuni.productshop.util.FormatConverter;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsersFromJSON(FormatConverter converter, String typeFormat) throws IOException, UnableToConvertException;
    User findRandomUser();

    List<UserWithSoldProductsDto> soldProduct();

    UsersAndProductsDto usersAndProducts();
    void seedUsersFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException;

    UserWithSoldProductsDtoXML soldProductForXML();
}
