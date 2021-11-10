package dao.mongo;

import java.util.ArrayList;
import java.util.Collection;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.client.model.Filters.*;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;

import hu.uni.miskolc.teszteles2021.Auto;
import hu.uni.miskolc.teszteles2021.dao.AutoDao;
import hu.uni.miskolc.teszteles2021.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles2021.exception.RendszamMarFoglalt;

public class AutoDAOMongo implements AutoDao {
	private MongoCollection<AutoPojo> collection;
	
	public AutoDAOMongo(String uri, String database, String collection) {
		ConnectionString connection = new ConnectionString(uri);
		
		//Automatikus átkonvertálást viszi végbe
		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codedRegistry = fromProviders(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
		
		MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connection).
					codecRegistry(codedRegistry).build();
		MongoClient client = MongoClients.create(clientSettings);
		MongoDatabase db = client.getDatabase(database);
		this.collection = db.getCollection(collection, AutoPojo.class);
	}
	
	@Override
	public Collection<Auto> readAllAutos() {
		return collection.find().map(AutoPojoConverter::pojoToAutoConvert).into(new ArrayList());
	}

	@Override
	public Auto readAutoById(String rendszam) throws AutoNemTalalhato {
		return collection.find(eq("_id", rendszam)).map(AutoPojoConverter::pojoToAutoConvert).first();
	}

	@Override
	public void createAuto(Auto auto) throws RendszamMarFoglalt {
		try {
		collection.insertOne(AutoPojoConverter.autoToPojoConvert(auto));
		} catch(MongoWriteException e) {
			throw new RendszamMarFoglalt(auto.getRendszam());
		}
	}

	@Override
	public void updateAuto(Auto auto) {
		
	}

	@Override
	public void deleteAuto(Auto auto) {
		
	}

	@Override
	public void deleteAutoById(String rendszam) {
		
	}

	
}
