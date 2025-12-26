package org.sheepy.lily.core.model.ui;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.InferenceModelDefinition;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.presentation.PresentationModelDefinition;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.core.model.ui.builder.BooleanActionButtonBuilder;
import org.sheepy.lily.core.model.ui.builder.BooleanButtonBuilder;
import org.sheepy.lily.core.model.ui.builder.ButtonBuilder;
import org.sheepy.lily.core.model.ui.builder.DynamicRowLayoutBuilder;
import org.sheepy.lily.core.model.ui.builder.FontBuilder;
import org.sheepy.lily.core.model.ui.builder.FontPkgBuilder;
import org.sheepy.lily.core.model.ui.builder.FontTableBuilder;
import org.sheepy.lily.core.model.ui.builder.LabelBuilder;
import org.sheepy.lily.core.model.ui.builder.PanelBuilder;
import org.sheepy.lily.core.model.ui.builder.SliderBuilder;
import org.sheepy.lily.core.model.ui.builder.TextFieldBuilder;
import org.sheepy.lily.core.model.ui.builder.UIBuilder;
import org.sheepy.lily.core.model.ui.builder.UIPageBuilder;
import org.sheepy.lily.core.model.ui.builder.VariableLabelBuilder;

public interface UIModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<IUIElement> IUI_ELEMENT = new GroupBuilder<IUIElement>().name("IUIElement").addInclude(() -> new IncludeBuilder<IInferenceObject>().group(() -> InferenceModelDefinition.Groups.I_INFERENCE_OBJECT).build()).addFeatures(IUIElement.Features.ALL).build();
    Group<IPanel> I_PANEL = new GroupBuilder<IPanel>().name("IPanel").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addInclude(() -> new IncludeBuilder<IUIElement>().group(() -> IUI_ELEMENT).build()).addInclude(() -> new IncludeBuilder<IPositionElement>().group(() -> PresentationModelDefinition.Groups.I_POSITION_ELEMENT).build()).addFeatures(IPanel.Features.ALL).build();
    Group<Panel> PANEL = new GroupBuilder<Panel>().name("Panel").concrete(true).addInclude(() -> new IncludeBuilder<IPanel>().group(() -> I_PANEL).build()).addInclude(() -> new IncludeBuilder<ISizedElement>().group(() -> PresentationModelDefinition.Groups.I_SIZED_ELEMENT).build()).addFeatures(Panel.Features.ALL).lmBuilder(new BuilderSupplier<>(PanelBuilder::new)).build();
    Group<UI> UI = new GroupBuilder<UI>().name("UI").concrete(true).addInclude(() -> new IncludeBuilder<ICompositor>().group(() -> ApplicationModelDefinition.Groups.I_COMPOSITOR).build()).addFeatures(org.sheepy.lily.core.model.ui.UI.Features.ALL).lmBuilder(new BuilderSupplier<>(UIBuilder::new)).build();
    Group<UIPage> UI_PAGE = new GroupBuilder<UIPage>().name("UIPage").concrete(true).addInclude(() -> new IncludeBuilder<ISizedElement>().group(() -> PresentationModelDefinition.Groups.I_SIZED_ELEMENT).build()).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(UIPage.Features.ALL).lmBuilder(new BuilderSupplier<>(UIPageBuilder::new)).build();
    Group<IControl> I_CONTROL = new GroupBuilder<IControl>().name("IControl").addInclude(() -> new IncludeBuilder<IUIElement>().group(() -> IUI_ELEMENT).build()).addFeatures(IControl.Features.ALL).build();
    Group<Widget> WIDGET = new GroupBuilder<Widget>().name("Widget").addInclude(() -> new IncludeBuilder<IControl>().group(() -> I_CONTROL).build()).addInclude(() -> new IncludeBuilder<IUIElement>().group(() -> IUI_ELEMENT).build()).addInclude(() -> new IncludeBuilder<ISizedElement>().group(() -> PresentationModelDefinition.Groups.I_SIZED_ELEMENT).build()).addFeatures(Widget.Features.ALL).build();
    Group<TextWidget> TEXT_WIDGET = new GroupBuilder<TextWidget>().name("TextWidget").addInclude(() -> new IncludeBuilder<Widget>().group(() -> WIDGET).build()).addFeatures(TextWidget.Features.ALL).build();
    Group<AbstractLabel> ABSTRACT_LABEL = new GroupBuilder<AbstractLabel>().name("AbstractLabel").addInclude(() -> new IncludeBuilder<TextWidget>().group(() -> TEXT_WIDGET).build()).addFeatures(AbstractLabel.Features.ALL).build();
    Group<DynamicRowLayout> DYNAMIC_ROW_LAYOUT = new GroupBuilder<DynamicRowLayout>().name("DynamicRowLayout").concrete(true).addInclude(() -> new IncludeBuilder<IControl>().group(() -> I_CONTROL).build()).addFeatures(DynamicRowLayout.Features.ALL).lmBuilder(new BuilderSupplier<>(DynamicRowLayoutBuilder::new)).build();
    Group<VariableLabel> VARIABLE_LABEL = new GroupBuilder<VariableLabel>().name("VariableLabel").concrete(true).addInclude(() -> new IncludeBuilder<AbstractLabel>().group(() -> ABSTRACT_LABEL).build()).addFeatures(VariableLabel.Features.ALL).lmBuilder(new BuilderSupplier<>(VariableLabelBuilder::new)).build();
    Group<Label> LABEL = new GroupBuilder<Label>().name("Label").concrete(true).addInclude(() -> new IncludeBuilder<AbstractLabel>().group(() -> ABSTRACT_LABEL).build()).addFeatures(Label.Features.ALL).lmBuilder(new BuilderSupplier<>(LabelBuilder::new)).build();
    Group<Slider> SLIDER = new GroupBuilder<Slider>().name("Slider").concrete(true).addInclude(() -> new IncludeBuilder<TextWidget>().group(() -> TEXT_WIDGET).build()).addFeatures(Slider.Features.ALL).lmBuilder(new BuilderSupplier<>(SliderBuilder::new)).build();
    Group<TextField> TEXT_FIELD = new GroupBuilder<TextField>().name("TextField").concrete(true).addInclude(() -> new IncludeBuilder<TextWidget>().group(() -> TEXT_WIDGET).build()).addFeatures(TextField.Features.ALL).lmBuilder(new BuilderSupplier<>(TextFieldBuilder::new)).build();
    Group<AbstractButton> ABSTRACT_BUTTON = new GroupBuilder<AbstractButton>().name("AbstractButton").addInclude(() -> new IncludeBuilder<TextWidget>().group(() -> TEXT_WIDGET).build()).addFeatures(AbstractButton.Features.ALL).build();
    Group<Button> BUTTON = new GroupBuilder<Button>().name("Button").concrete(true).addInclude(() -> new IncludeBuilder<AbstractButton>().group(() -> ABSTRACT_BUTTON).build()).addFeatures(Button.Features.ALL).lmBuilder(new BuilderSupplier<>(ButtonBuilder::new)).build();
    Group<AbstractBooleanButton> ABSTRACT_BOOLEAN_BUTTON = new GroupBuilder<AbstractBooleanButton>().name("AbstractBooleanButton").addInclude(() -> new IncludeBuilder<AbstractButton>().group(() -> ABSTRACT_BUTTON).build()).addFeatures(AbstractBooleanButton.Features.ALL).build();
    Group<BooleanButton> BOOLEAN_BUTTON = new GroupBuilder<BooleanButton>().name("BooleanButton").concrete(true).addInclude(() -> new IncludeBuilder<AbstractBooleanButton>().group(() -> ABSTRACT_BOOLEAN_BUTTON).build()).addFeatures(BooleanButton.Features.ALL).lmBuilder(new BuilderSupplier<>(BooleanButtonBuilder::new)).build();
    Group<BooleanActionButton> BOOLEAN_ACTION_BUTTON = new GroupBuilder<BooleanActionButton>().name("BooleanActionButton").concrete(true).addInclude(() -> new IncludeBuilder<AbstractBooleanButton>().group(() -> ABSTRACT_BOOLEAN_BUTTON).build()).addFeatures(BooleanActionButton.Features.ALL).lmBuilder(new BuilderSupplier<>(BooleanActionButtonBuilder::new)).build();
    Group<FontPkg> FONT_PKG = new GroupBuilder<FontPkg>().name("FontPkg").concrete(true).addFeatures(FontPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(FontPkgBuilder::new)).build();
    Group<FontTable> FONT_TABLE = new GroupBuilder<FontTable>().name("FontTable").concrete(true).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(FontTable.Features.ALL).lmBuilder(new BuilderSupplier<>(FontTableBuilder::new)).build();
    Group<Font> FONT = new GroupBuilder<Font>().name("Font").concrete(true).addInclude(() -> new IncludeBuilder<IRootResource>().group(() -> ResourceModelDefinition.Groups.I_ROOT_RESOURCE).build()).addFeatures(Font.Features.ALL).lmBuilder(new BuilderSupplier<>(FontBuilder::new)).build();
    List<Group<?>> ALL = List.of(IUI_ELEMENT, I_PANEL, PANEL, UI, UI_PAGE, I_CONTROL, WIDGET, TEXT_WIDGET, ABSTRACT_LABEL, DYNAMIC_ROW_LAYOUT, VARIABLE_LABEL, LABEL, SLIDER, TEXT_FIELD, ABSTRACT_BUTTON, BUTTON, ABSTRACT_BOOLEAN_BUTTON, BOOLEAN_BUTTON, BOOLEAN_ACTION_BUTTON, FONT_PKG, FONT_TABLE, FONT);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    List<Enum<?>> ALL = List.of();
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    List<JavaWrapper<?>> ALL = List.of();
  }
}
