package com.github.telvarost.betterscreenshots;

import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonPrimitive;
import com.google.common.collect.ImmutableMap;
import net.glasslauncher.mods.api.gcapi.api.ConfigFactoryProvider;
import net.glasslauncher.mods.api.gcapi.api.MaxLength;
import net.glasslauncher.mods.api.gcapi.impl.NonFunction;
import net.glasslauncher.mods.api.gcapi.impl.config.ConfigEntry;
import net.glasslauncher.mods.api.gcapi.impl.config.entry.EnumConfigEntry;

import java.lang.reflect.*;
import java.util.function.*;

public class IsometricAngleEnumFactory implements ConfigFactoryProvider {
    @Override
    public void provideLoadFactories(ImmutableMap.Builder<Type, NonFunction<String, String, String, Field, Object, Boolean, Object, Object, MaxLength, ConfigEntry<?>>> immutableBuilder) {
        immutableBuilder.put(IsometricAngleEnum.class, ((id, name, description, parentField, parentObject, isMultiplayerSynced, enumOrOrdinal, defaultEnum, maxLength) ->
        {
            int enumOrdinal;
            if(enumOrOrdinal instanceof Integer ordinal) {
                enumOrdinal = ordinal;
            }
            else {
                enumOrdinal = ((IsometricAngleEnum) enumOrOrdinal).ordinal();
            }
            return new EnumConfigEntry<IsometricAngleEnum>(id, name, description, parentField, parentObject, isMultiplayerSynced, enumOrdinal, ((IsometricAngleEnum) defaultEnum).ordinal(), IsometricAngleEnum.class);
        }));
    }

    @Override
    public void provideSaveFactories(ImmutableMap.Builder<Type, Function<Object, JsonElement>> immutableBuilder) {
        immutableBuilder.put(IsometricAngleEnum.class, enumEntry -> new JsonPrimitive(((IsometricAngleEnum) enumEntry).ordinal()));
    }

    @Override
    public void provideLoadTypeAdapterFactories(@SuppressWarnings("rawtypes") ImmutableMap.Builder<Type, Class> immutableBuilder) {
        immutableBuilder.put(IsometricAngleEnum.class, Integer.class);
    }
}
