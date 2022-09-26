package controller;

import model.*;
import org.junit.jupiter.api.*;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CookieControllerTest {

    private CookieControllerI cookieController;
    private IngredientControllerI mockedIngredientController;
    private Recipe recipe;
    private Dough mockedDough;

    @BeforeEach
    void setUp() {
        this.recipe = new Recipe("Chocolate chip cookies", 10);
    }

    @Test
    void prepareDough_collectsAllIngredients() {

        // Arrange
        mockedIngredientController = mock(IngredientControllerI.class);
        cookieController = new CookieController(mockedIngredientController);
        recipe.createIngredient("Butter", Ingredient.Unit.GRAM, 120);
        recipe.createIngredient("Sugar", Ingredient.Unit.GRAM, 150);
        recipe.createIngredient("Egg", Ingredient.Unit.PCS, 1);

        // Act
        cookieController.prepareDough(recipe);

        // Assert
        verify(mockedIngredientController).collectIngredient("Butter", 120);
        verify(mockedIngredientController).collectIngredient("Sugar", 150);
        verify(mockedIngredientController).collectIngredient("Egg", 1);
    }

    @Test
    void makeCookies_usesAllDoughPieces() {

        // Arrange
        mockedDough = mock(Dough.class);
        cookieController = new CookieController();
        when(mockedDough.createCookie()).thenReturn(new Cookie(mockedDough));
        when(mockedDough.getPiecesRemaining()).thenReturn(1, 5, 10);

        // Act
        Cookie[] cookiesFrom1pc = cookieController.makeCookies(mockedDough);
        Cookie[] cookiesFrom5pcs = cookieController.makeCookies(mockedDough);
        Cookie[] cookiesFrom10pcs = cookieController.makeCookies(mockedDough);

        // Assert
        assertEquals(1, cookiesFrom1pc.length);
        assertEquals(5, cookiesFrom5pcs.length);
        assertEquals(10, cookiesFrom10pcs.length);
    }


    @Test
    void storeIngredient() {
        //arrange
        IngredientController ingredientController = new IngredientController();
        Ingredient ingredient = new Ingredient("sukker", Ingredient.Unit.PCS, 10);
        //act
        ingredientController.storeIngredient(ingredient);

        //assert
        assertEquals(ingredient, ingredientController.getIngredients().get("sukker"));
    }

    @Test
    void storeIngredientException() {
        //arrange
        IngredientController ingredientController = new IngredientController();
        Ingredient i1 = new Ingredient("sukker", Ingredient.Unit.PCS, 10);
        ingredientController.storeIngredient(i1);
        Ingredient i2 = new Ingredient("sukker", Ingredient.Unit.GRAM, 500);
        //act
        Exception exception = assertThrows(RuntimeException.class, () -> {
            ingredientController.storeIngredient(i2);
        });
        assertEquals(exception.getMessage(), "forkert unit");
    }
}