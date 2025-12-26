package org.sheepy.lily.core.model.types;

import java.util.List;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4dc;
import org.joml.Vector4fc;
import org.joml.Vector4ic;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Generic;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Model;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.EnumAttributeBuilder;
import org.logoce.lmf.core.lang.builder.EnumBuilder;
import org.logoce.lmf.core.lang.builder.GenericBuilder;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.logoce.lmf.core.lang.builder.JavaWrapperBuilder;
import org.logoce.lmf.core.lang.builder.SerializerBuilder;
import org.sheepy.lily.core.model.types.builder.BooleanParameterBuilder;
import org.sheepy.lily.core.model.types.builder.FloatParameterBuilder;
import org.sheepy.lily.core.model.types.builder.ModelPartBuilder;
import org.sheepy.lily.core.model.types.builder.StringParameterBuilder;

public interface TypesModelDefinition {
  interface Generics {
    interface NATIVE_PARAMETER {
      Generic<?> T = new GenericBuilder<>().name("T").build();
      List<Generic<?>> ALL = List.of(T);
    }
  }

  interface Groups {
    Group<LNamedElement> L_NAMED_ELEMENT = new GroupBuilder<LNamedElement>().name("LNamedElement").addInclude(() -> new IncludeBuilder<Named>().group(() -> LMCoreModelDefinition.Groups.NAMED).build()).addFeatures(LNamedElement.Features.ALL).build();
    Group<ModelPart> MODEL_PART = new GroupBuilder<ModelPart>().name("ModelPart").concrete(true).addInclude(() -> new IncludeBuilder<Model>().group(() -> LMCoreModelDefinition.Groups.MODEL).build()).addFeatures(ModelPart.Features.ALL).lmBuilder(new BuilderSupplier<>(ModelPartBuilder::new)).build();
    Group<Parameter> PARAMETER = new GroupBuilder<Parameter>().name("Parameter").addFeatures(Parameter.Features.ALL).build();
    Group<PositionParameter> POSITION_PARAMETER = new GroupBuilder<PositionParameter>().name("PositionParameter").addInclude(() -> new IncludeBuilder<Parameter>().group(() -> PARAMETER).build()).addFeatures(PositionParameter.Features.ALL).build();
    Group<PositionFParameter> POSITIONF_PARAMETER = new GroupBuilder<PositionFParameter>().name("PositionFParameter").addInclude(() -> new IncludeBuilder<Parameter>().group(() -> PARAMETER).build()).addFeatures(PositionFParameter.Features.ALL).build();
    Group<NativeParameter<?>> NATIVE_PARAMETER = new GroupBuilder<NativeParameter<?>>().name("NativeParameter").addInclude(() -> new IncludeBuilder<Parameter>().group(() -> PARAMETER).build()).addFeatures(NativeParameter.Features.ALL).addGenerics(Generics.NATIVE_PARAMETER.ALL).build();
    Group<FloatParameter> FLOAT_PARAMETER = new GroupBuilder<FloatParameter>().name("FloatParameter").concrete(true).addInclude(() -> new IncludeBuilder<NativeParameter<?>>().group(() -> NATIVE_PARAMETER).addParameter(() -> new GenericParameterBuilder().type(() -> LMCoreModelDefinition.Units.FLOAT).build()).build()).addFeatures(FloatParameter.Features.ALL).lmBuilder(new BuilderSupplier<>(FloatParameterBuilder::new)).build();
    Group<StringParameter> STRING_PARAMETER = new GroupBuilder<StringParameter>().name("StringParameter").concrete(true).addInclude(() -> new IncludeBuilder<NativeParameter<?>>().group(() -> NATIVE_PARAMETER).addParameter(() -> new GenericParameterBuilder().type(() -> LMCoreModelDefinition.Units.STRING).build()).build()).addFeatures(StringParameter.Features.ALL).lmBuilder(new BuilderSupplier<>(StringParameterBuilder::new)).build();
    Group<BooleanParameter> BOOLEAN_PARAMETER = new GroupBuilder<BooleanParameter>().name("BooleanParameter").concrete(true).addInclude(() -> new IncludeBuilder<NativeParameter<?>>().group(() -> NATIVE_PARAMETER).addParameter(() -> new GenericParameterBuilder().type(() -> LMCoreModelDefinition.Units.BOOLEAN).build()).build()).addFeatures(BooleanParameter.Features.ALL).lmBuilder(new BuilderSupplier<>(BooleanParameterBuilder::new)).build();
    List<Group<?>> ALL = List.of(L_NAMED_ELEMENT, MODEL_PART, PARAMETER, POSITION_PARAMETER, POSITIONF_PARAMETER, NATIVE_PARAMETER, FLOAT_PARAMETER, STRING_PARAMETER, BOOLEAN_PARAMETER);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    Enum<ENotificationDirection> E_NOTIFICATION_DIRECTION = new EnumBuilder<ENotificationDirection>().name("ENotificationDirection").addLiterals(List.of("Parent", "Children", "Self", "All")).build();
    Enum<EMoveState> E_MOVE_STATE = new EnumBuilder<EMoveState>().name("EMoveState").addLiterals(List.of("START_MOVING", "STOP_MOVING")).build();
    Enum<EDirection> E_DIRECTION = new EnumBuilder<EDirection>().name("EDirection").addLiterals(List.of("UP", "LEFT", "RIGHT", "DOWN")).build();
    Enum<ETimeUnit> E_TIME_UNIT = new EnumBuilder<ETimeUnit>().name("ETimeUnit").addLiterals(List.of("NANOSECONDS", "0", "MICROSECONDS", "1", "MILLISECONDS", "2", "SECONDS", "3", "MINUTES", "4", "HOURS", "5", "DAYS", "6")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    Enum<ENumberComparisonType> E_NUMBER_COMPARISON_TYPE = new EnumBuilder<ENumberComparisonType>().name("ENumberComparisonType").addLiterals(List.of("Equal", "InfOrEqual", "SupOrEqual", "Inf", "Sup")).build();
    Enum<ERelative> E_RELATIVE = new EnumBuilder<ERelative>().name("ERelative").addLiterals(List.of("HORIZONTAL", "0", "VERTICAL", "1")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    Enum<EVerticalRelative> E_VERTICAL_RELATIVE = new EnumBuilder<EVerticalRelative>().name("EVerticalRelative").addLiterals(List.of("BOTTOM", "MIDDLE", "TOP")).build();
    Enum<EHorizontalRelative> E_HORIZONTAL_RELATIVE = new EnumBuilder<EHorizontalRelative>().name("EHorizontalRelative").addLiterals(List.of("LEFT", "MIDDLE", "RIGHT")).build();
    Enum<EMouseButton> E_MOUSE_BUTTON = new EnumBuilder<EMouseButton>().name("EMouseButton").addLiterals(List.of("RIGHT", "LEFT", "MIDDLE", "_4", "_5", "_6", "_7", "_8")).build();
    Enum<EKeyState> E_KEY_STATE = new EnumBuilder<EKeyState>().name("EKeyState").addLiterals(List.of("RELEASED", "0", "PRESSED", "1", "REPEATED", "2")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    Enum<ECharTable> E_CHAR_TABLE = new EnumBuilder<ECharTable>().name("ECharTable").addLiterals(List.of("Base", "Extended", "Chinese")).build();
    List<Enum<?>> ALL = List.of(E_NOTIFICATION_DIRECTION, E_MOVE_STATE, E_DIRECTION, E_TIME_UNIT, E_NUMBER_COMPARISON_TYPE, E_RELATIVE, E_VERTICAL_RELATIVE, E_HORIZONTAL_RELATIVE, E_MOUSE_BUTTON, E_KEY_STATE, E_CHAR_TABLE);
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    JavaWrapper<Vector4dc> VECTOR4D = new JavaWrapperBuilder<Vector4dc>().name("Vector4d").qualifiedClassName("org.joml.Vector4dc").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==4){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);double w=Double.parseDouble(split[3]);return new org.joml.Vector4d(x,y,z,w);}}return new org.joml.Vector4d(0,0,0,0);").convert("if(it!=null){double x=it.x();double y=it.y();double z=it.z();double w=it.w();return (x+\";\"+y+\";\"+z+\";\"+w);}return \"0;0;0;0\";").build()).build();
    JavaWrapper<Vector4fc> VECTOR4F = new JavaWrapperBuilder<Vector4fc>().name("Vector4f").qualifiedClassName("org.joml.Vector4fc").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==4){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);float w=Float.parseFloat(split[3]);return new org.joml.Vector4f(x,y,z,w);}}return new org.joml.Vector4f(0f,0f,0f,0f);").convert("if(it!=null){float x=it.x();float y=it.y();float z=it.z();float w=it.w();return (x+\";\"+y+\";\"+z+\";\"+w);}return \"0;0;0;0\";").build()).build();
    JavaWrapper<Vector4ic> VECTOR4I = new JavaWrapperBuilder<Vector4ic>().name("Vector4i").qualifiedClassName("org.joml.Vector4ic").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==4){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);int w=Integer.parseInt(split[3]);return new org.joml.Vector4i(x,y,z,w);}}return new org.joml.Vector4i(0,0,0,0);").convert("if(it!=null){int x=it.x();int y=it.y();int z=it.z();int w=it.w();return (x+\";\"+y+\";\"+z+\";\"+w);}return \"0;0;0;0\";").build()).build();
    JavaWrapper<Vector4fc> COLOR4F = new JavaWrapperBuilder<Vector4fc>().name("Color4f").qualifiedClassName("org.joml.Vector4fc").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==4){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);float w=Float.parseFloat(split[3]);return new org.joml.Vector4f(x,y,z,w);}}return new org.joml.Vector4f(0f,0f,0f,0f);").convert("if(it!=null){float x=it.x();float y=it.y();float z=it.z();float w=it.w();return (x+\";\"+y+\";\"+z+\";\"+w);}return \"0;0;0;0\";").build()).build();
    JavaWrapper<Vector3fc> COLOR3F = new JavaWrapperBuilder<Vector3fc>().name("Color3f").qualifiedClassName("org.joml.Vector3fc").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==3){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);return new org.joml.Vector3f(x,y,z);}}return new org.joml.Vector3f(0f,0f,0f);").convert("if(it!=null){float x=it.x();float y=it.y();float z=it.z();return (x+\";\"+y+\";\"+z);}return \"0;0;0\";").build()).build();
    JavaWrapper<Vector3dc> VECTOR3D = new JavaWrapperBuilder<Vector3dc>().name("Vector3d").qualifiedClassName("org.joml.Vector3dc").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==3){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);return new org.joml.Vector3d(x,y,z);}}return new org.joml.Vector3d(0,0,0);").convert("if(it!=null){double x=it.x();double y=it.y();double z=it.z();return (x+\";\"+y+\";\"+z);}return \"0;0;0\";").build()).build();
    JavaWrapper<Vector3fc> VECTOR3F = new JavaWrapperBuilder<Vector3fc>().name("Vector3f").qualifiedClassName("org.joml.Vector3fc").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==3){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);return new org.joml.Vector3f(x,y,z);}}return new org.joml.Vector3f(0f,0f,0f);").convert("if(it!=null){float x=it.x();float y=it.y();float z=it.z();return (x+\";\"+y+\";\"+z);}return \"0;0;0\";").build()).build();
    JavaWrapper<Vector3ic> VECTOR3I = new JavaWrapperBuilder<Vector3ic>().name("Vector3i").qualifiedClassName("org.joml.Vector3ic").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==3){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);return new org.joml.Vector3i(x,y,z);}}return new org.joml.Vector3i(0,0,0);").convert("if(it!=null){int x=it.x();int y=it.y();int z=it.z();return (x+\";\"+y+\";\"+z);}return \"0;0;0\";").build()).build();
    JavaWrapper<Vector2fc> VECTOR2F = new JavaWrapperBuilder<Vector2fc>().name("Vector2f").qualifiedClassName("org.joml.Vector2fc").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==2){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);return new org.joml.Vector2f(x,y);}}return new org.joml.Vector2f(0f,0f);").convert("if(it!=null){float x=it.x();float y=it.y();return (x+\";\"+y);}return \"0;0\";").build()).build();
    JavaWrapper<Vector2ic> VECTOR2I = new JavaWrapperBuilder<Vector2ic>().name("Vector2i").qualifiedClassName("org.joml.Vector2ic").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0);").convert("if(it!=null){int x=it.x();int y=it.y();return (x+\";\"+y);}return \"0;0\";").build()).build();
    JavaWrapper<Vector2dc> VECTOR2D = new JavaWrapperBuilder<Vector2dc>().name("Vector2d").qualifiedClassName("org.joml.Vector2dc").serializer(() -> new SerializerBuilder().create("if(it!=null){final String[] split=it.split(\";\");if(split.length==2){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);return new org.joml.Vector2d(x,y);}}return new org.joml.Vector2d(0,0);").convert("if(it!=null){double x=it.x();double y=it.y();return (x+\";\"+y);}return \"0;0\";").build()).build();
    JavaWrapper<Module> JAVA_MODULE = new JavaWrapperBuilder<Module>().name("JavaModule").qualifiedClassName("java.lang.Module").build();
    JavaWrapper<Object> JAVA_OBJECT = new JavaWrapperBuilder<Object>().name("JavaObject").qualifiedClassName("java.lang.Object").build();
    List<JavaWrapper<?>> ALL = List.of(VECTOR4D, VECTOR4F, VECTOR4I, COLOR4F, COLOR3F, VECTOR3D, VECTOR3F, VECTOR3I, VECTOR2F, VECTOR2I, VECTOR2D, JAVA_MODULE, JAVA_OBJECT);
  }
}
