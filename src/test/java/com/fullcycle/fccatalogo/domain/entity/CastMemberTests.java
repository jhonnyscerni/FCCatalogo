package com.fullcycle.fccatalogo.domain.entity;

import com.fullcycle.fccatalogo.domain.entity.enums.CastMemberType;
import com.fullcycle.fccatalogo.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CastMemberTests {

    //Criação com Name
    @Test
    void createCasteMemberWithNameTest() {
        CastMember entity = new CastMember(TestUtils.DEFAULT_CASTEMEMBER_NAME_1);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(TestUtils.DEFAULT_CASTEMEMBER_NAME_1, entity.getName());
        Assertions.assertTrue(entity.isValidUUID(entity.getId().toString()));
        Assertions.assertNull(entity.getType());
    }

    //Criação com Name e Type
    @Test
    @EnumSource(value = CastMemberType.class)
    void createCasteMemberWithNameAndTypeTest() {
        CastMember entity = new CastMember(TestUtils.DEFAULT_CASTEMEMBER_NAME_1, TestUtils.DEFAULT_CASTEMEMBER_TYPE_1);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(TestUtils.DEFAULT_CASTEMEMBER_NAME_1, entity.getName());
        Assertions.assertTrue(entity.isValidUUID(entity.getId().toString()));
        Assertions.assertTrue(CastMemberType.valueOf(entity.getType()));
        Assertions.assertEquals(TestUtils.DEFAULT_CASTEMEMBER_TYPE_1, entity.getType());
    }

    //Verificando Validação NotNull
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CastMember(null));
    }

    //Verificando Validação NotBlank
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNotBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CastMember(""));
    }

    //Verificando Validação NotNull
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNullAndIsType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CastMember(null, null));
    }

    //Verificando Validação NotBlank
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNotBlankAndIsType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CastMember("", null));
    }

    //Verificando Validação NotNull
    @Test
    void throwIllegalArgumentExceptionWhenTypeIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CastMember("Cast Member 1", null));
    }

    //Verificando Validação TypeisNotValid
    @Test
    void throwIllegalArgumentExceptionWhenTypeIsNotValid() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CastMember entity = Mockito.mock(CastMember.class);

            entity.setName(TestUtils.DEFAULT_CASTEMEMBER_NAME_1);
            Mockito.doThrow(IllegalArgumentException.class).when(entity).setType(TestUtils.DEFAULT_CASTEMEMBER_TYPE_2);
            entity.setType(TestUtils.DEFAULT_CASTEMEMBER_TYPE_2);
        });
    }

}
