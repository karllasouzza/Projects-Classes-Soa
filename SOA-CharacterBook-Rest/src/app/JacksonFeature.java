package app;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.CommonProperties;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class JacksonFeature implements Feature {
	
	@Provider
	public class JacksonProvider extends com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider {		
		public JacksonProvider() {
			ObjectMapper mapper = new ObjectMapper().registerModule(new JodaModule());
			mapper = mapper.setSerializationInclusion(Include.NON_NULL);
			setMapper(mapper);
		}
	}	
		
	public boolean configure(final FeatureContext context) {
		final String disableMoxy = CommonProperties.MOXY_JSON_FEATURE_DISABLE + '.'
                + context.getConfiguration().getRuntimeType().name().toLowerCase();
		context.property(disableMoxy, true);
		context.register(JacksonJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
        return true;
    }
}