package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.index.AbstractHollowUniqueKeyIndex;
import com.netflix.hollow.core.schema.HollowObjectSchema;

@SuppressWarnings("all")
public class TerritoryCountriesPrimaryKeyIndex extends AbstractHollowUniqueKeyIndex<VMSHollowInputAPI, TerritoryCountriesHollow> {

    public TerritoryCountriesPrimaryKeyIndex(HollowConsumer consumer) {
        this(consumer, ((HollowObjectSchema)consumer.getStateEngine().getSchema("TerritoryCountries")).getPrimaryKey().getFieldPaths());
    }

    public TerritoryCountriesPrimaryKeyIndex(HollowConsumer consumer, String... fieldPaths) {
        this(consumer, true, fieldPaths);
    }

    public TerritoryCountriesPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefreah, String... fieldPaths) {
        super(consumer, "TerritoryCountries", isListenToDataRefreah, fieldPaths);
    }

    public TerritoryCountriesHollow findMatch(Object... keys) {
        int ordinal = idx.getMatchingOrdinal(keys);
        if(ordinal == -1)
            return null;
        return api.getTerritoryCountriesHollow(ordinal);
    }

}