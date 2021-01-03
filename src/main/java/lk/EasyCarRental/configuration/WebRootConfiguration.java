package lk.EasyCarRental.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({SpringDataJpaConfiguration.class})
public class WebRootConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }




}
