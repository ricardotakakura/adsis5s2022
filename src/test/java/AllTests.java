import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import adsis5s2022.estoque.TestesComEstoque;
import aula20220304.calculadora.TestesIntrodutórios;
import junit.extensions.TestSetup;

@RunWith(Suite.class)
@SuiteClasses({TestesComEstoque.class, TestesIntrodutórios.class})
public class AllTests {

}
