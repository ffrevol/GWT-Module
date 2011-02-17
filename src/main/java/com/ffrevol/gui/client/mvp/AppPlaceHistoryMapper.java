package com.ffrevol.gui.client.mvp;

import com.ffrevol.gui.client.place.ServiceFilterPlace;
import com.ffrevol.gui.client.place.ServicePlace;
import com.ffrevol.gui.client.place.ServiceTypePlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers( { ServiceTypePlace.Tokenizer.class, ServicePlace.Tokenizer.class, ServiceFilterPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
