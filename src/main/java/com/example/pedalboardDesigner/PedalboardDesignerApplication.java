package com.example.pedalboardDesigner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pedalboardDesigner.model.Pedal;
import com.example.pedalboardDesigner.model.Type;
import com.example.pedalboardDesigner.model.PedalRepository;
import com.example.pedalboardDesigner.model.TypeRepository;
import com.example.pedalboardDesigner.model.UserRepository;




@SpringBootApplication
public class PedalboardDesignerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PedalboardDesignerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PedalboardDesignerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner pedalDemo(PedalRepository prepo, TypeRepository trepo, UserRepository urepo) {
		return(args) -> {
			
			log.info("Save a few things");
			
			// Depopulate repositories on restart
//			prepo.deleteAll();
			
			// Save types
			
//			trepo.save(new Type("Chorus"));
//			trepo.save(new Type("Compressor"));
//			trepo.save(new Type("Delay"));
//			trepo.save(new Type("Distortion"));
//			trepo.save(new Type("Equalizer"));
//			trepo.save(new Type("Flanger"));
//			trepo.save(new Type("Fuzz"));
//			trepo.save(new Type("Looper"));
//			trepo.save(new Type("Overdrive"));
//			trepo.save(new Type("Phaser"));
//			trepo.save(new Type("MultiFX"));
//			trepo.save(new Type("Tuner"));		
//			trepo.save(new Type("Reverb"));
//			trepo.save(new Type("Tremolo"));		
//			trepo.save(new Type("Other"));
					
			// Save some pedals
			
//			prepo.save(new Pedal("Big Muff", "Electro Harmonix", 50, trepo.findByName("Fuzz").get(0)));
//			prepo.save(new Pedal("DD-2", "BOSS", 150, trepo.findByName("Delay").get(0)));
			
			for(Pedal pedal : prepo.findAll()) {
				log.info(pedal.toString());
			}

			
		};
		
	}

}
