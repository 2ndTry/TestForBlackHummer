package com.alexeymiroshnikov.springweb.spring_max_letter.controller;

import com.alexeymiroshnikov.springweb.spring_max_letter.model.ResponseFormat;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/wordanalyzer/analyze")
public class ResponseController {

    @GetMapping()
    public ResponseFormat getResult(@RequestParam(value = "word") String scanString) {

        String reverseString = new StringBuilder(scanString).reverse().toString();
        char[] arrayLetters = reverseString.toCharArray();

        Map<Character, Integer> mapLetters = countLetter(arrayLetters);

        char maxKey = 0;
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : mapLetters.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxKey = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        ResponseFormat responseFormat = new ResponseFormat(maxKey, maxCount);

        return responseFormat;
    }

    public static Map<Character, Integer> countLetter(char[] letters) {
        LinkedHashMap<Character, Integer> result = new LinkedHashMap<>();

        for (Character letter : letters) {
            int count = result.getOrDefault(letter, 0);
            result.put(letter, count + 1);
        }
        return result;
    }
}
