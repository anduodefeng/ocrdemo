package com.example.ocr;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/** *
 * Description: 
 * ClassName: OcrWord
 * Author: maze
 * Date: 2019/3/1 16:28
 **/
public class OcrResult {

    @JsonProperty(value = "log_id")
    private String logId;
    @JsonProperty(value = "words_result")
    private List<Map<String, String>> wordsResult;
    @JsonProperty(value = "words_result_num")
    private String wordsResultNum;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public List<Map<String, String>> getWordsResult() {
        return wordsResult;
    }

    public void setWordsResult(List<Map<String, String>> wordsResult) {
        this.wordsResult = wordsResult;
    }

    public String getWordsResultNum() {
        return wordsResultNum;
    }

    public void setWordsResultNum(String wordsResultNum) {
        this.wordsResultNum = wordsResultNum;
    }
}
