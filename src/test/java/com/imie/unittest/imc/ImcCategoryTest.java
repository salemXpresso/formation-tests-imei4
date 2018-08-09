package com.imie.unittest.imc;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class ImcCategoryTest {

    private ImcCategory imcCategory = new ImcCategory();

    @Test
    public void testGetCategory_veryLowImc_return1() {

        assertThat(imcCategory.getCategory(16)).isEqualTo(1);
    }

    @Test
    public void testGetCategory_veryHighImc_return7() {

        assertThat(imcCategory.getCategory(100)).isEqualTo(7);
    }

    @Test
    public void testGetCategory_normal_return3() {

        assertThat(imcCategory.getCategory(19)).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCategory_negativeImc_returnException() {

        imcCategory.getCategory(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCategoryLabel_unknownCategory_returnException() {

        imcCategory.getCategoryLabel(10);
    }

    @Test
    public void testGetCategory_nominal_returnNonEmptyString() {

        assertThat(imcCategory.getCategoryLabel(4)).isNotEmpty();
    }
}
