package TP4;

import java.util.Stack;

public class Calculette
{
	private final Stack<Double> pile = new Stack<>();

	public void empiler(double valeur)
	{
		pile.push(valeur);
	}

	public double additionner()
	{
		exiger(2);
		double b = pile.pop();
		double a = pile.pop();
		double r = a + b;
		pile.push(r);
		return r;
	}

	public double soustraire()
	{
		exiger(2);
		double b = pile.pop();
		double a = pile.pop();
		double r = a - b;
		pile.push(r);
		return r;
	}

	public double multiplier()
	{
		exiger(2);
		double b = pile.pop();
		double a = pile.pop();
		double r = a * b;
		pile.push(r);
		return r;
	}

	public double diviser()
	{
		exiger(2);
		double b = pile.pop();
		if (b == 0.0)
		{
			throw new ArithmeticException("Division par zéro");
		}
		double a = pile.pop();
		double r = a / b;
		pile.push(r);
		return r;
	}

	public double sommet()
	{
		if (pile.isEmpty())
		{
			throw new IllegalStateException("Pile vide");
		}
		return pile.peek();
	}

	public int taille()
	{
		return pile.size();
	}

	public void vider()
	{
		pile.clear();
	}

	public double evaluer(String expression)
	{
		if (expression == null)
		{
			throw new IllegalArgumentException("Expression nulle");
		}
		vider();
		String[] jetons = expression.trim().split("\\s+");
		for (String t : jetons)
		{
			if (t.equals("+"))
			{
				additionner();
			}
			else if (t.equals("-"))
			{
				soustraire();
			}
			else if (t.equals("*"))
			{
				multiplier();
			}
			else if (t.equals("/"))
			{
				diviser();
			}
			else if (!t.isEmpty())
			{
				double v = Double.parseDouble(t);
				empiler(v);
			}
		}
		if (taille() != 1)
		{
			throw new IllegalStateException("Expression invalide");
		}
		return sommet();
	}

	private void exiger(int n)
	{
		if (pile.size() < n)
		{
			throw new IllegalStateException("Pile insuffisante");
		}
	}
}
