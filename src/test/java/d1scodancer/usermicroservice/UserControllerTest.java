package d1scodancer.usermicroservice;

import d1scodancer.usermicroservice.rest.UserController;
import d1scodancer.usermicroservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void deleteUserReturnsNoContent() throws Exception {
        long userId = 1L;
        mockMvc.perform(delete("/api/v1/users/" + userId))
                .andExpect(status().isNoContent());
        Mockito.verify(userService).deleteUser(userId);
    }
}
