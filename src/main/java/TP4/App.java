package TP4;

public class App
{
    public static void main(String[] args)
    {
        Calculette calc = new Calculette();
        String expr;
        if (args != null && args.length > 0)
        {
            expr = String.join(" ", args);
        }
        else
        {
            try
            {
                java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
                String line = br.readLine();
                expr = line != null ? line : "";
            }
            catch (Exception e)
            {
                System.err.println("Erreur de lecture: " + e.getMessage());
                System.exit(2);
                return;
            }
        }

        try
        {
            double res = calc.evaluer(expr);
            System.out.println(res);
        }
        catch (Exception e)
        {
            System.err.println("Erreur: " + e.getMessage());
            System.exit(1);
        }
    }
}
