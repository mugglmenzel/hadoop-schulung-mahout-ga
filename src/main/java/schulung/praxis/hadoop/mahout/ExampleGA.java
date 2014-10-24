package schulung.praxis.hadoop.mahout;

import java.util.List;
import java.util.Random;

import org.apache.mahout.ga.watchmaker.MahoutFitnessEvaluator;
import org.apache.mahout.ga.watchmaker.STEvolutionEngine;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvaluatedCandidate;
import org.uncommons.watchmaker.framework.PopulationData;
import org.uncommons.watchmaker.framework.TerminationCondition;
import org.uncommons.watchmaker.framework.operators.Replacement;
import org.uncommons.watchmaker.framework.selection.TournamentSelection;

import schulung.praxis.hadoop.mahout.ga.DoubleCandidateFactory;
import schulung.praxis.hadoop.mahout.ga.DoubleFitnessEvaluator;

public class ExampleGA {

	public static void main(String[] args) throws Exception {
		STEvolutionEngine<Double> gee = new STEvolutionEngine<Double>(
				new DoubleCandidateFactory(), 
				new Replacement<Double>(new DoubleCandidateFactory(), new Probability(0.5D)), 
				new MahoutFitnessEvaluator<Double>(new DoubleFitnessEvaluator()), 
				new TournamentSelection(new Probability(0.75D)), 
				new Random());
		List<EvaluatedCandidate<Double>> best = gee.evolvePopulation(100, 10, 
				new TerminationCondition() {
			
			@Override
			public boolean shouldTerminate(PopulationData<?> data) {
				System.out.println("Generation: " + data.getGenerationNumber() + ", Time elapsed: " + data.getElapsedTime());
				return data.getGenerationNumber() > 1000 || data.getElapsedTime() > 3*60*1000;
			}
		});
		
		System.out.println("[GA Example] Best candidate: " + best.iterator().next().getCandidate());
	}

}
