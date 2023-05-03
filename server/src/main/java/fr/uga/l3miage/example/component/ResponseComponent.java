package fr.uga.l3miage.example.component;


import fr.uga.l3miage.example.exception.technical.QuestionNotFoundException;
import fr.uga.l3miage.example.exception.technical.ResponseEntityNotFoundException;
import fr.uga.l3miage.example.mapper.ResponseMapper;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Response;
import fr.uga.l3miage.example.repository.ResponseRepository;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.response.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ResponseComponent {
    private final ResponseRepository responseRepository;
    private final QuestionComponent questionComponent;
    private final ResponseMapper responseMapper;

    public Response getResponse(final Long id ) throws QuestionNotFoundException {
        return responseRepository.getResponseById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Aucune question ne possede" + id ));
    }

    public List<Response> getResponsesByQuestion(Long questionId){
        if(questionId != null){
            return responseRepository.getResponsesByQuestion(questionId);
        }else{
            throw new QuestionNotFoundException("on peut pas recuperer les reponses d'une question inexstante");
        }
    }

    public void createResponse(Long questionId ,final Response response) throws QuestionNotFoundException {
        if (responseRepository.getResponseById(response.getId()).isPresent()) {
            throw new QuestionNotFoundException("La question suivant "+ response.getId()+"deja existante.");
        } else if(questionComponent.getQuestion(questionId) == null){
            throw new QuestionNotFoundException("aucune question ne possede cette "+questionId);
        }else {
            Question question = questionComponent.getQuestion(questionId);
            response.setQuestion(question);
            responseRepository.save(response);
        }
    }

    @Transactional
    public void deleteResponse(final Long id) throws QuestionNotFoundException {
        Long deleted = responseRepository.deleteResponseById(id);
        if (deleted == 0)
            throw new QuestionNotFoundException("Aucune question ne possede"+ id);

    }

    public void updateResponse(final Long id, ResponseDTO response){
        Response newResponse = responseRepository.getResponseById(id)
                .orElseThrow(() -> new ResponseEntityNotFoundException("Aucune entité n'a été trouvée avec cette reponse " + id));
        newResponse.setLabel(response.getLabel());
        newResponse.setEstValide(response.isEstValide());
        responseRepository.save(newResponse);
    }


}
