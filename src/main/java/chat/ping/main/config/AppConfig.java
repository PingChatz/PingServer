package chat.ping.main.config;


import chat.ping.main.entity.user.UserFactory;
import chat.ping.main.infrastructure.auth.presenter.UserRegisterPresenter;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.infrastructure.security.JWTUtils;
import chat.ping.main.usecase.auth.login.UserLoginInteractor;
import chat.ping.main.usecase.auth.login.UserLoginPresenter;
import chat.ping.main.usecase.auth.register.UserRegisterInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig
{
    @Bean
    public UserRegisterPresenter userRegisterPresenter()
    {
        return new UserRegisterPresenter();
    }

    @Bean
    public UserRegisterInteractor userRegisterInteractor(UserAuthDsGateway userAuthDsGateway,
                                                         UserRegisterPresenter userRegisterPresenter,
                                                         UserFactory userFactory)
    {
        return new UserRegisterInteractor(
                userAuthDsGateway,
                userRegisterPresenter,
                userFactory
        );
    }

    @Bean
    public UserLoginPresenter userLoginPresenter()
    {
        return new UserLoginPresenter();
    }

    @Bean
    public UserLoginInteractor userLoginInteractor(UserAuthDsGateway userAuthDsGateway,
                                                   PasswordEncoder passwordEncoder,
                                                   UserLoginPresenter userLoginPresenter,
                                                   JWTUtils jwtUtils)
    {
        return new UserLoginInteractor(
                userAuthDsGateway,
                passwordEncoder,
                userLoginPresenter,
                jwtUtils
        );
    }

    @Bean
    public UserFactory userFactory(PasswordEncoder passwordEncoder)
    {
        return new UserFactory(passwordEncoder);
    }
}
