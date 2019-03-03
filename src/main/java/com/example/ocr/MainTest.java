package com.example.ocr;

import com.baidu.aip.ocr.AipOcr;
import org.joda.time.DateTime;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** *
 * Description: OCR主要测试类
 * ClassName: MainTest
 * Author: maze
 * Date: 2019/3/1 16:20
 **/
public class MainTest {

    private static final String APP_ID = "15657224";
    private static final String API_KEY = "0AePYVG5Dz35V59sPOZAiDp3";
    private static final String SECRET_KEY = "8GzQ7cHNGMEXcDVXg7y1nnveMqv3GMDx";
    private static final JsonMapper json = JsonMapper.nonDefaultMapper();
    // 初始化一个AipOcr
    private static final AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

    public static void main(String[] args) throws IOException {

        List<String> fileNames = readFile();
        List<String> ocrResult = ocrReturn(fileNames);
        for(String file : ocrResult){
            List<Map<String, String>> mapList = json.fromJson(file, json.contructCollectionType(List.class, Map.class));
            saveFile(mapList);
        }
    }

    /** *
     * Description: 保存转换后文档
     * Author: maze
     * Date: 2019/3/1 18:11
     * Params: [mapList]
     * Return: void
     **/
    private static void saveFile(List<Map<String, String>> mapList) throws IOException {

        File file = new File("/Users/maze/Desktop/image/word");
        if(!file.exists()){
            file.mkdir();
        }
        String fileName = "转换文档"+DateTime.now().toString("yyyyMMddHHmmss")+".doc";
        file = new File("/Users/maze/Desktop/image/word/"+fileName);
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, true);
        for(Map<String, String> map : mapList){
            String value = map.get("words");
            fileWriter.append(value);
            fileWriter.append("\r\n");
        }
        fileWriter.close();
    }

    /** *
     * Description: 读取图片文件夹
     * Author: maze
     * Date: 2019/3/1 17:03
     * Params: []
     * Return: java.util.List<java.lang.String>
     **/
    private static List<String> readFile(){

        List<String> fileNames = new ArrayList<>();

        File file = new File("/Users/maze/Desktop/image/");
        File[] files = file.listFiles();
        for(File file1 : files){
            //遇见目录略过，并且略过mac系统中的隐藏文件夹
            if(file1.isDirectory() || file1.getName().equals(".DS_Store")){
                continue;
            }
            fileNames.add(file1.getAbsolutePath());
        }
        return fileNames;
    }

    /** *
     * Description: 百度识别返回结果
     * Author: maze
     * Date: 2019/3/1 17:14
     * Params: [fileNames]
     * Return: java.util.List<java.lang.String>
     **/
    private static List<String> ocrReturn(List<String> fileNames){

        List<String> ocrWord = new ArrayList<>();

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        for(String fileName : fileNames){
            JSONObject res = client.basicGeneral(fileName, new HashMap<>());
            OcrResult ocrResult = json.fromJson(res.toString(), OcrResult.class);
            List<Map<String, String>> mapList = ocrResult.getWordsResult();
            ocrWord.add(json.toJson(mapList));
        }

        return ocrWord;
    }
}
