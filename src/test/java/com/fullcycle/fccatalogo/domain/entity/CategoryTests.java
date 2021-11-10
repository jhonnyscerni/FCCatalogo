package com.fullcycle.fccatalogo.domain.entity;

import com.fullcycle.fccatalogo.utils.TestUtils;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryTests {

    //Criação
    @Test
    void createCategory() {
        Category entity = new Category(TestUtils.DEFAULT_CATEGORY_NAME_1);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals("Category 1", entity.getName());
        Assertions.assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    //Verificando Validação NotNull
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category((String) null));
    }

    //Verificando Validação NotNull
    @Test
    void throwIllegalArgumentExceptionWhenIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category((UUID) null));
    }

    //Verificando Validação NotBlank
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNotBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category(""));
    }
}
