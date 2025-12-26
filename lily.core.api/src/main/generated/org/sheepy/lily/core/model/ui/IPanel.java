package org.sheepy.lily.core.model.ui;

import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.LNamedElement;

public interface IPanel extends LNamedElement, IUIElement, IPositionElement {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean catchInputs();
  boolean reportingHover();
  void catchInputs(final boolean catchInputs);
  void reportingHover(final boolean reportingHover);

  interface FeatureIDs {
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int NAME = Named.FeatureIDs.NAME;
    int CATCH_INPUTS = 604497673;
    int REPORTING_HOVER = -1401531639;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T>, IUIElement.Features<T>, IPositionElement.Features<T> {
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> CATCH_INPUTS = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("catchInputs").mandatory(true).defaultValue("true").id(IPanel.FeatureIDs.CATCH_INPUTS).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> REPORTING_HOVER = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("reportingHover").mandatory(true).defaultValue("true").id(IPanel.FeatureIDs.REPORTING_HOVER).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, NAME, CATCH_INPUTS, REPORTING_HOVER);
  }
}
