package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

class BeanValidationTest {

    @Test
    void beanValidation() throws Exception {

        // given
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // when
        Item item = new Item();
        item.setItemName("");
        item.setPrice(0);
        item.setQuantity(1000000);

        // then
        Set<ConstraintViolation<Item>> violations = validator.validate(item);

        for (ConstraintViolation<Item> violation : violations) {
            System.out.println("validation = " + violation);
            System.out.println("validation.class = " + violation.getMessage());
        }
    }
}
