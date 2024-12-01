package chat.ping.main.config;


import chat.ping.main.entity.MessageThread.MessageThreadFactory;
import chat.ping.main.entity.Messaging.MessageFactory;
import chat.ping.main.entity.user.UserFactory;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.infrastructure.auth.presenter.UserLoginPresenter;
import chat.ping.main.infrastructure.auth.presenter.UserRegisterPresenter;
import chat.ping.main.infrastructure.messaging.gateway.messages.MessageGateway;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import chat.ping.main.infrastructure.messaging.presenter.CreateThreadPresenter;
import chat.ping.main.infrastructure.messaging.presenter.GetMessagesPresenter;
import chat.ping.main.infrastructure.messaging.presenter.GetThreadsPresenter;
import chat.ping.main.infrastructure.messaging.presenter.SendMessagePresenter;
import chat.ping.main.infrastructure.security.JWTUtils;
import chat.ping.main.usecase.auth.login.UserLoginInteractor;
import chat.ping.main.usecase.auth.register.UserRegisterInteractor;
import chat.ping.main.usecase.messaging.createThreads.CreateThreadInteractor;
import chat.ping.main.usecase.messaging.getMessages.GetMessageInteractor;
import chat.ping.main.usecase.messaging.getThreads.GetThreadsInteractor;
import chat.ping.main.usecase.messaging.sendMessage.SendMessageInteractor;
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


    @Bean
    public MessageThreadFactory messageThreadFactory()
    {
        return new MessageThreadFactory();
    }

    @Bean
    public MessageFactory messageFactory()
    {
        return new MessageFactory();
    }

    @Bean
    public CreateThreadPresenter createThreadPresenter()
    {
        return new CreateThreadPresenter();
    }

    @Bean
    public GetThreadsPresenter getThreadsPresenter()
    {
        return new GetThreadsPresenter();
    }

    @Bean
    public GetMessagesPresenter getMessagesPresenter()
    {
        return new GetMessagesPresenter();
    }

    @Bean
    public SendMessagePresenter sendMessagePresenter()
    {
        return new SendMessagePresenter();
    }

    @Bean
    public CreateThreadInteractor createThreadInteractor(ThreadGateway threadGateway,
                                                         UserAuthDsGateway userAuthDsGateway,
                                                         CreateThreadPresenter presenter,
                                                         MessageThreadFactory threadFactory)
    {
        return new CreateThreadInteractor(threadGateway, userAuthDsGateway, presenter, threadFactory);
    }

    @Bean
    public GetThreadsInteractor getThreadsInteractor(ThreadGateway threadGateway,
                                                     GetThreadsPresenter presenter)
    {
        return new GetThreadsInteractor(threadGateway, presenter);
    }

    @Bean
    public GetMessageInteractor getMessagesInteractor(MessageGateway messageGateway,
                                                      ThreadGateway threadGateway,
                                                      GetMessagesPresenter presenter)
    {
        return new GetMessageInteractor(messageGateway, threadGateway, presenter);
    }

    @Bean
    public SendMessageInteractor sendMessageInteractor(MessageGateway messageGateway,
                                                       ThreadGateway threadGateway,
                                                       UserAuthDsGateway userAuthDsGateway,
                                                       SendMessagePresenter presenter,
                                                       MessageFactory messageFactory)
    {
        return new SendMessageInteractor(messageGateway, threadGateway, userAuthDsGateway, presenter, messageFactory);
    }

    @Bean
    public JWTUtils jwtUtils()
    {
        return new JWTUtils();
    }
}
