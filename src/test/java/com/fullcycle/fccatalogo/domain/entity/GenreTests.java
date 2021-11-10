package com.fullcycle.fccatalogo.domain.entity;

import com.fullcycle.fccatalogo.utils.TestUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GenreTests {

    //Criação com Name
    @Test
    void createGenreWithNameTest() {
        Genre entity = new Genre(TestUtils.DEFAULT_GENRE_NAME_1);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals("Genre 1", entity.getName());
        Assertions.assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    //Criação com Name e Categorias
    @Test
    void createGenreWithNameAndCategoriesTest() {
        Category category1 = new Category(TestUtils.DEFAULT_CATEGORY_NAME_1);
        Category category2 = new Category(TestUtils.DEFAULT_CATEGORY_NAME_2);

        List<Category> categories = new ArrayList<>();
        categories.add(category1);
        categories.add(category2);

        Genre entity = new Genre(TestUtils.DEFAULT_GENRE_NAME_1, categories);

        Assertions.assertNotNull(categories);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(TestUtils.DEFAULT_GENRE_NAME_1, entity.getName());
        Assertions.assertTrue(entity.isValidUUID(entity.getId().toString()));
        Assertions.assertEquals(TestUtils.DEFAULT_CATEGORY_NAME_1, category1.getName());
        Assertions.assertEquals(TestUtils.DEFAULT_CATEGORY_NAME_2, category2.getName());
        Assertions.assertTrue(category1.isValidUUID(category1.getId().toString()));
        Assertions.assertTrue(category2.isValidUUID(category2.getId().toString()));
        Assertions.assertEquals(2, entity.getCategories().size());


    }

    //Adicionando Categoria em Genero
    @Test
    void addCategoryToGenreTest() {
        Genre entity = new Genre(TestUtils.DEFAULT_GENRE_NAME_1);

        Assertions.assertNotNull(entity);

        Category category1 = new Category(TestUtils.DEFAULT_CATEGORY_NAME_1);
        Category category2 = new Category(TestUtils.DEFAULT_CATEGORY_NAME_2);

        entity.addCategory(category1);
        entity.addCategory(category2);

        Assertions.assertNotNull(entity.getCategories());
        Assertions.assertEquals(2, entity.getCategories().size());
    }

    //Adicionando e Removendo Categoria em Genero
    @Test
    void removeCategoryToGenreTest() {
        Genre entity = new Genre(TestUtils.DEFAULT_GENRE_NAME_1);

        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getCategories());

        Category category1 = new Category(TestUtils.DEFAULT_CATEGORY_NAME_1);
        Category category2 = new Category(TestUtils.DEFAULT_CATEGORY_NAME_2);

        entity.addCategory(category1);
        entity.addCategory(category2);

        Assertions.assertNotNull(entity.getCategories());

        Assertions.assertEquals(2, entity.getCategories().size());
        entity.removeCategory(category1);
        Assertions.assertEquals(1, entity.getCategories().size());
        entity.removeCategory(category2);
        Assertions.assertEquals(0, entity.getCategories().size());

        Assertions.assertNotNull(entity.getCategories());
    }

    //Verificando Validação NotNull
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Genre(null));
    }

    //Verificando Validação NotBlank
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNotBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Genre(""));
    }

    //Verificando Validação NotNull
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNullAndCategoriesIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Genre((String) null, null));
    }

    //Verificando Validação NotBlank
    @Test
    void throwIllegalArgumentExceptionWhenNameIsNotBlankAndCategoriesIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Genre("", null));
    }

}
