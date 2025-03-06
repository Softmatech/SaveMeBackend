package com.softmatech.save_me.Loader;

import com.softmatech.save_me.entity.DocumentType;
import com.softmatech.save_me.entity.Person;
import com.softmatech.save_me.entity.Sexe;
import com.softmatech.save_me.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonRepository personRepository;

    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //One possible approach is to use a SimpleDateFormat and the java.sql.Date(long) constructor like

        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        java.sql.Date sqlDate = new java.sql.Date(df.parse("02-04-2015").getTime());
        // Create Persons
        Person person1 = new Person("Andy","Example", Sexe.Masculin,"andy@email.com", sqlDate, "Fort-liberté"," 3, cite notre dame Fort liberte", "Haiti", "Haitien", "3428930493", DocumentType.CARTE_IDENTITICATION,"Danise Pierre", "Marie Louise","Celibataire");

        // Save Persons to the database
//        personRepository.save(person1);

//        System.out.println("Sample data populated");
    }
}
