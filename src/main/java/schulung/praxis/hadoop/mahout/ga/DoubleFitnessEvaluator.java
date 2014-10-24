package schulung.praxis.hadoop.mahout.ga;

import java.util.List;

import org.apache.mahout.ga.watchmaker.STFitnessEvaluator;

import com.google.common.collect.Lists;

public class DoubleFitnessEvaluator extends STFitnessEvaluator<Double> {

	@Override
	public double getFitness(Double candidate, List<? extends Double> population) {
		return candidate;
	}

	@Override
	protected void evaluate(List<? extends Double> pop, List<Double> evals) {
		//Not needed!
		System.out.println("Evaluating population: " + pop + " with evals: "
				+ evals);
		if (pop != null)
			evals.addAll(pop);
		else
			pop = Lists.newArrayList();
	}

	@Override
	public boolean isNatural() {
		return true;
	}

}
