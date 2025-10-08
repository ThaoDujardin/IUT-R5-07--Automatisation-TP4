package TP4;

import junit.framework.TestCase;

public class CalculetteTest extends TestCase {

    private Calculette c;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        c = new Calculette();
    }

    public void testEmpilerEtSommet() {
        c.empiler(1.5);
        assertEquals(1, c.taille());
        assertEquals(1.5, c.sommet());
    }

    public void testAdditionner() {
        c.empiler(1.0);
        c.empiler(3.0);
        double r = c.additionner();
        assertEquals(4.0, r);
        assertEquals(4.0, c.sommet());
    }

    public void testSoustraire() {
        c.empiler(7.0);
        c.empiler(2.5);
        double r = c.soustraire();
        assertEquals(4.5, r);
        assertEquals(4.5, c.sommet());
    }

    public void testMultiplier() {
        c.empiler(2.0);
        c.empiler(3.5);
        double r = c.multiplier();
        assertEquals(7.0, r);
        assertEquals(7.0, c.sommet());
    }

    public void testEvaluerSimple() {
        double r = c.evaluer("1 2 +");
        assertEquals(3.0, r);
    }

    public void testEvaluerSoustraction() {
        double r = c.evaluer("7 2.5 -");
        assertEquals(4.5, r);
    }

    public void testEvaluerMultiplication() {
        double r = c.evaluer("2 3.5 *");
        assertEquals(7.0, r);
    }

    public void testEvaluerExpressionInvalide() {
        try {
            c.evaluer("1 2");
            fail("Devrait lever une IllegalStateException");
        } catch (IllegalStateException expected) {
            // ok
        }
    }
}
