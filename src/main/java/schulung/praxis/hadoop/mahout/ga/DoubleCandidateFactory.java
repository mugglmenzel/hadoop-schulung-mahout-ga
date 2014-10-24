package schulung.praxis.hadoop.mahout.ga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.CandidateFactory;

public class DoubleCandidateFactory implements CandidateFactory<Double> {

	@Override
	public List<Double> generateInitialPopulation(int size, Random rdm) {
		List<Double> pop = new ArrayList<Double>();
		for(int i = 0; i < size; i++)
			pop.add(rdm.nextDouble());
		System.out.println("Generated init population (size: " + pop.size() + "): " + pop);
		return pop;
	}

	@Override
	public List<Double> generateInitialPopulation(int size,
			Collection<Double> seed, Random rdm) {
		List<Double> pop = new ArrayList<Double>();
		pop.addAll(seed);
		for(int i = seed.size(); i < size; i++)
			pop.add(rdm.nextDouble());
		System.out.println("Generated seed population (size: " + pop.size() + "): " + pop);
		return pop;
	}

	@Override
	public Double generateRandomCandidate(Random rdm) {
		//System.out.println("Generated random candidate.");
		return rdm.nextDouble();
	}

}
