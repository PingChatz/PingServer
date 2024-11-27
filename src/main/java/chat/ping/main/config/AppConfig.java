package chat.ping.main.config;


import chat.ping.main.entity.user.UserFactory;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.usecase.auth.register.UserRegisterInteractor;
import chat.ping.main.usecase.auth.register.UserRegisterPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public UserRegisterInteractor userRegisterInteractor(UserAuthDsGateway userAuthDsGateway)
    {
        return new UserRegisterInteractor(
                userAuthDsGateway,
                new UserRegisterPresenter(),
                new UserFactory());
    }
}
