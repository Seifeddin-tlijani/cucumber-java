import com.tlijani.cucumber.model.Person;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PersonFeatureSteps {

    private PersonService personService = new PersonServiceImpl();
    private List<Person> personList;
    private int personsInitSize = 0;
    private int personsInitSizeAfterSave = 0;


    @Given("^Static method to Initialize a list of persons$")
    public void initilize_a_list_of_persons(){
        initPersonList();
    }

    @When("^I connect, I can see the size of the Initialized persons$")
    public void when_i_connect_i_can_see_the_list(){
        personsInitSize = personList.size();
    }

    @Then("^the list size is equal to 5$")
    public void then_the_list_size_is_equal_to_5(){
        Assert.assertEquals(5, personsInitSize);
    }

    // implmenting Create person
    @Given("^the list of persons contains 5 persons already stored$")
    public void list_contains_5_persons(){
        initPersonList();
        personsInitSize=personList.size();
    }
    @When("^I create a new person with random entry$")
    public void when_i_create_new_person_with_random_entries(){
        Person randomPerson = new Person();
        randomPerson.setId(6L);
        randomPerson.setFirstName("random");
        randomPerson.setLastName("random");
        randomPerson.setAge(35);
        savedPerson = personService.save(randomPerson);

        findAllPersons();
        personsInitSizeAfterSave = personList.size();
    }
    @Then("^I get the ID of the new person and the list contains more than 5 persons$")
    public void then_i_get_the_list(){
        Assert.assertEquals(personsInitSizeAfterSave , 6);
        Assert.assertNotNull(savedPerson);
    }
    private void initPersonList(){
        personList = this.personService.init();
    }
    private void findAllPersons(){
        personList=this.personService.findAll();
    }
}
