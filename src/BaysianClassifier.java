
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;


public class BaysianClassifier {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader bReader = new BufferedReader(new FileReader("C:\\Program Files\\Weka-3-7\\data\\weather.arff"));
		
		Instances train = new Instances(bReader);
		train.setClassIndex(train.numAttributes() - 1);
		
		bReader.close();
		
		NaiveBayes nBayes = new NaiveBayes();
		nBayes.buildClassifier(train);
				
		Evaluation eval = new Evaluation(train);
		eval.crossValidateModel(nBayes, train, 5 , new Random(2));
		
		System.out.println(eval.toSummaryString("\nResults\n",true));
		System.out.println(eval.fMeasure(1) + "  "+ eval.precision(1)+ "  "+ eval.recall(1));
		
	}

}
