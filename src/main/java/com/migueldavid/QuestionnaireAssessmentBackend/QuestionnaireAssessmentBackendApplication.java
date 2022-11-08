package com.migueldavid.QuestionnaireAssessmentBackend;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Answer;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.User;
import com.migueldavid.QuestionnaireAssessmentBackend.services.AnswerService;
import com.migueldavid.QuestionnaireAssessmentBackend.services.QuestionService;
import com.migueldavid.QuestionnaireAssessmentBackend.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class QuestionnaireAssessmentBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(QuestionnaireAssessmentBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(QuestionService questionService, UserService userService, AnswerService answerService) {

		return args -> {

			Question question1 = new Question(1, "¿Que tiene que ver el tocino con la velocidad?");
			questionService.addQuestion(new Question(1, "¿Que tiene que ver el tocino con la velocidad?"));
			questionService.addQuestion(new Question(2, "¿A cuantos va a despedir Solera?"));

			List<Answer> answerList = new ArrayList<>();
			answerList.add(new Answer(1, "Mucho", question1));
			answerList.add(new Answer(2, "Poco", question1));





			answerService.addAnswerToQuestion(new Answer(1, "Mucho", question1));
			answerService.addAnswerToQuestion(new Answer(2, "Poco", question1));

			Question question2 =new Question(2, "¿A cuantos va a despedir Solera?");
//
			answerService.addAnswerToQuestion(new Answer(1, "A muchos", question2));
			answerService.addAnswerToQuestion(new Answer(2, "A todos", question2));
//
//
//

			userService.addUser(new User(1, "mangelmunoz877@gmail.com", answerList));
//			userService.addUser(new User(2, "dededec@gmail.com"));

		};
	};
}

