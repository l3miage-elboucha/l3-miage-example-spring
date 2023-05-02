package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.repository.TeacherRepository;
import fr.uga.l3miage.example.service.ServiceTeacher;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;


@AutoConfigureTestDatabase
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
public class TeacherControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @SpyBean
    private ServiceTeacher spyTeacherService;
    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * Éxécuté à la fin de chaque test
     */
    @AfterEach
    void clear() {
        teacherRepository.deleteAll();
    }


    /*@Test
    void getTeacher() {
        *//* BASED ON THIS ABOVE, DO THE TEST getTeacher() *//*

        final Long id = 1L;
        final HttpHeaders headers = new HttpHeaders();

        final Map<String, Object> urlParams = new HashMap<>();
        urlParams.put("id", id);

        TeacherDTO excepted = TeacherDTO
                .builder()
                .id(1L)
                .nom("name")
                .build();

        doReturn(excepted).when(spyTeacherService).getTeacher(id);

        ResponseEntity<TeacherDTO> response = testRestTemplate.exchange(
                "/teacher/{id}", HttpMethod.GET, new HttpEntity<>(null, headers),
                TeacherDTO.class, urlParams);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(excepted);
    }*/
}
