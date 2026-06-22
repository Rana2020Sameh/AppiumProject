package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.LoginData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    public static List<LoginData> getLoginData() throws IOException {

        // 1. حدد مكان الـ file
        String filePath = "src/test/resources/testdata/loginData.json";

        // 2. Jackson بيقرأ الـ file ويحوله لـ List من LoginData objects
        ObjectMapper mapper = new ObjectMapper();
        List<LoginData> dataList = mapper.readValue(
                new File(filePath),
                new TypeReference<List<LoginData>>() {}
        );

        // 3. ارجع البيانات
        return dataList;
    }
}
