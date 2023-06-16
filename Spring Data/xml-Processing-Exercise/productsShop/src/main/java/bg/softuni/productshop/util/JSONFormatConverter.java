package bg.softuni.productshop.util;

import bg.softuni.productshop.excetption.UnableToConvertException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component("json_format_converter")
public class JSONFormatConverter implements FormatConverter {

    private final GsonBuilder gsonBuilder;
    private Gson gson = null;

    public JSONFormatConverter(GsonBuilder gsonBuilder) {
        this.gsonBuilder = gsonBuilder;

    }


    @Override
    public void setPrettyPrint() {
        this.gsonBuilder.setPrettyPrinting();
        gson = null;
    }

    @Override
    public String serialize(Object obj)  {
        return this.getGson().toJson(obj);
    }

    @Override
    public void serialize(Object obj, String filename) throws UnableToConvertException {
        try (FileWriter fw = new FileWriter(filename)) {
            this.getGson().toJson(
                    obj,
                    fw);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToConvertException();
        }
    }

    @Override
    public <T> void serializeList(List<T> objectLists, String filename)  {
        try (FileWriter fw = new FileWriter(filename)) {
            this.getGson().toJson(
                    objectLists,
                    fw);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public <T> T deserialize(String input, Class<T> toType) {

        return this.getGson().fromJson(input, toType);
    }

    @Override
    public <T> T deserializeFromFile(String fileName, Class<T> toType) throws UnableToConvertException {

        try (FileReader fr = new FileReader(fileName)) {
            return this.getGson().fromJson(
                    fr,
                    toType);
        } catch (IOException e) {
            e.printStackTrace();
           throw new UnableToConvertException();

        }

    }

    private Gson getGson() {
        if (this.gson == null) {
            this.gson = this.gsonBuilder.create();
        }
        return this.gson;
    }
}
