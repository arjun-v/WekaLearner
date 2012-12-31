package miningResources;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import sun.misc.IOUtils;
import AssociationRules.AprioriAssociationRules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Miner {


	public static void main(String[] args) {

		try {

			InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("miningResources/config.json");

			Gson gson = new GsonBuilder().create();
			String jsonString = new String(IOUtils.readFully(stream, -1, false));
			stream.close();
			JsonParser parser = new JsonParser();
			JsonArray Jarray = parser.parse(jsonString).getAsJsonArray();
			List<MineSettings> settings = new ArrayList<MineSettings>();

			for(JsonElement obj : Jarray )
			{
				MineSettings cse = gson.fromJson(obj, MineSettings.class);
				settings.add(cse);
			}

			AprioriAssociationRules apriori = new AprioriAssociationRules();
			apriori.build(settings.get(0).getFILE(),settings.get(0).getOPTIONS());


		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
