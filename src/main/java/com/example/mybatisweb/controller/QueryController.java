package com.example.mybatisweb.controller;

import com.example.mybatisweb.dto.QueryDTO;
import com.example.mybatisweb.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.*;

@RequiredArgsConstructor
@Controller
public class QueryController {

    private final QueryRepository queryRepository;

    @GetMapping({"", "main"})
    public String main() {
        return "main";
    }

    @PostMapping("main")
    public String select(@ModelAttribute("dto") @Valid QueryDTO dto, BindingResult bindingResult, Model model ) {


        if (dto.getQuery().trim().toLowerCase().charAt(0) != 's' ) {
            bindingResult.addError(new FieldError("query", "query", "SELECT문만 가능합니다."));
        }



        if (bindingResult.hasErrors()) {
            System.out.println("bindingResult = " + bindingResult);
            return "main";
        }

        System.out.println(dto.getQuery());

        List<Map<String, Object>> stringObjectMap = queryRepository.getQuery(dto.getQuery());


        List<String> keyListOfQueryMap = new ArrayList<>(stringObjectMap.get(0).keySet());

        model.addAttribute("keys", keyListOfQueryMap);
        model.addAttribute("result", stringObjectMap);
        return "main";

    }
}
