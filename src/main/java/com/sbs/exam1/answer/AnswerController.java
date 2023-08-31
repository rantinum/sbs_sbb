package com.sbs.exam1.answer;

import com.sbs.exam1.question.Question;
import com.sbs.exam1.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;

    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Question question =  questionService.getQuestion(id);

        this.answerService.create(question, content);
        // TODO: 답변을 저장한다.
        return String.format("redirect:/question/detail/%s", id);
    }
}
