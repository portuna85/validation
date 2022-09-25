package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.*;

import static org.assertj.core.api.Assertions.*;

class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() throws Exception {
        // given
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");

        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        // when

        assertThat(messageCodes).contains("required.item", "required");
        // then

    }

    @Test
    void messageCodesResolverField() throws Exception {

        // given
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);


        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
