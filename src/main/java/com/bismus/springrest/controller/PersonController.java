package controller;

import com.bismus.springmvc.model.Person;
import com.bismus.springmvc.service.entityService.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/persons")
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public void  createPerson(@RequestBody Person person){
        personService.addNewPerson(person);
    }

    @GetMapping()
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") int id) {
        return personService.findById(id);
    }

    @GetMapping("/{name}")
    public List<Person> findByName(@PathVariable("name") String name) {
        return personService.findByName(name);
    }

    @PutMapping("/{id}")
    public void editPerson (@PathVariable("id") int id, @RequestBody Person person) {
        personService.updatePersonParam(id, person);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        personService.deletePerson(id);
    }
}