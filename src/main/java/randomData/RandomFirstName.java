package randomData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFirstName {
    public String printFirstName(boolean sex) throws IOException {

        String maleFirstName = "C:/DEV/Project/Test3InfinnitySolutions/src/main/resources/maleFirstNames.txt";
        String femaleFirstName = "C:/DEV/Project/Test3InfinnitySolutions/src/main/resources/femaleFirstNames.txt";
        String filePath;
        if (!sex) {
            filePath = femaleFirstName;
        } else {
            filePath = maleFirstName;
        }
        Random random = new Random();
        List<String> firstNames = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), "UTF8"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        String r;
        while ((r = in.readLine()) != null) {
            firstNames.add(r.replaceAll("\\s+",""));
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstNames.get(random.nextInt(firstNames.size()));
    }
}
