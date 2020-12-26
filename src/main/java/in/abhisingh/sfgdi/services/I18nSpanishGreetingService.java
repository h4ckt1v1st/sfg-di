package in.abhisingh.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//We need to setup the active profile in application.properties to remove the ambiguity.
// Spring will simply ignore and not load the inactive beans.
//@Profile("ES")

//In this way we can setup our bean for multiple profiles. In this case for ES and default profile.
//Upon setting up the default profile to a bean we don't need to setup active profile in application.properties.
@Profile({"ES", "default"})
//This is also a method to setup qualifiers string to make it something other than the class name with first lower case letter.
@Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
