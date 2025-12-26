package org.sheepy.lily.core.model.types;

import java.util.Optional;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4dc;
import org.joml.Vector4fc;
import org.joml.Vector4ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IJavaWrapperConverter;
import org.logoce.lmf.core.api.model.IModelPackage;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.MetaModel;
import org.logoce.lmf.core.lang.builder.MetaModelBuilder;

public final class TypesModelPackage implements IModelPackage {
  public static final TypesModelPackage Instance = new TypesModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Types").domain("org.sheepy.lily.core.model").genNamePackage(true).lmPackage(Instance).addGroups(TypesModelDefinition.Groups.ALL).addEnums(TypesModelDefinition.Enums.ALL).addUnits(TypesModelDefinition.Units.ALL).addAliases(TypesModelDefinition.Aliases.ALL).addJavaWrappers(TypesModelDefinition.JavaWrappers.ALL).build();

  private static final IJavaWrapperConverter<Vector4dc> VECTOR4D_CONVERTER = new IJavaWrapperConverter<Vector4dc>() {
    @Override
    public Vector4dc create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==4){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);double w=Double.parseDouble(split[3]);return new org.joml.Vector4d(x,y,z,w);}}return new org.joml.Vector4d(0,0,0,0);
    }

    @Override
    public String convert(Vector4dc it) {
      if(it!=null){double x=it.x();double y=it.y();double z=it.z();double w=it.w();return (x+";"+y+";"+z+";"+w);}return "0;0;0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector4fc> VECTOR4F_CONVERTER = new IJavaWrapperConverter<Vector4fc>() {
    @Override
    public Vector4fc create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==4){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);float w=Float.parseFloat(split[3]);return new org.joml.Vector4f(x,y,z,w);}}return new org.joml.Vector4f(0f,0f,0f,0f);
    }

    @Override
    public String convert(Vector4fc it) {
      if(it!=null){float x=it.x();float y=it.y();float z=it.z();float w=it.w();return (x+";"+y+";"+z+";"+w);}return "0;0;0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector4ic> VECTOR4I_CONVERTER = new IJavaWrapperConverter<Vector4ic>() {
    @Override
    public Vector4ic create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==4){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);int w=Integer.parseInt(split[3]);return new org.joml.Vector4i(x,y,z,w);}}return new org.joml.Vector4i(0,0,0,0);
    }

    @Override
    public String convert(Vector4ic it) {
      if(it!=null){int x=it.x();int y=it.y();int z=it.z();int w=it.w();return (x+";"+y+";"+z+";"+w);}return "0;0;0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector4fc> COLOR4F_CONVERTER = new IJavaWrapperConverter<Vector4fc>() {
    @Override
    public Vector4fc create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==4){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);float w=Float.parseFloat(split[3]);return new org.joml.Vector4f(x,y,z,w);}}return new org.joml.Vector4f(0f,0f,0f,0f);
    }

    @Override
    public String convert(Vector4fc it) {
      if(it!=null){float x=it.x();float y=it.y();float z=it.z();float w=it.w();return (x+";"+y+";"+z+";"+w);}return "0;0;0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector3fc> COLOR3F_CONVERTER = new IJavaWrapperConverter<Vector3fc>() {
    @Override
    public Vector3fc create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==3){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);return new org.joml.Vector3f(x,y,z);}}return new org.joml.Vector3f(0f,0f,0f);
    }

    @Override
    public String convert(Vector3fc it) {
      if(it!=null){float x=it.x();float y=it.y();float z=it.z();return (x+";"+y+";"+z);}return "0;0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector3dc> VECTOR3D_CONVERTER = new IJavaWrapperConverter<Vector3dc>() {
    @Override
    public Vector3dc create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==3){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);return new org.joml.Vector3d(x,y,z);}}return new org.joml.Vector3d(0,0,0);
    }

    @Override
    public String convert(Vector3dc it) {
      if(it!=null){double x=it.x();double y=it.y();double z=it.z();return (x+";"+y+";"+z);}return "0;0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector3fc> VECTOR3F_CONVERTER = new IJavaWrapperConverter<Vector3fc>() {
    @Override
    public Vector3fc create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==3){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);return new org.joml.Vector3f(x,y,z);}}return new org.joml.Vector3f(0f,0f,0f);
    }

    @Override
    public String convert(Vector3fc it) {
      if(it!=null){float x=it.x();float y=it.y();float z=it.z();return (x+";"+y+";"+z);}return "0;0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector3ic> VECTOR3I_CONVERTER = new IJavaWrapperConverter<Vector3ic>() {
    @Override
    public Vector3ic create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==3){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);return new org.joml.Vector3i(x,y,z);}}return new org.joml.Vector3i(0,0,0);
    }

    @Override
    public String convert(Vector3ic it) {
      if(it!=null){int x=it.x();int y=it.y();int z=it.z();return (x+";"+y+";"+z);}return "0;0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector2fc> VECTOR2F_CONVERTER = new IJavaWrapperConverter<Vector2fc>() {
    @Override
    public Vector2fc create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==2){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);return new org.joml.Vector2f(x,y);}}return new org.joml.Vector2f(0f,0f);
    }

    @Override
    public String convert(Vector2fc it) {
      if(it!=null){float x=it.x();float y=it.y();return (x+";"+y);}return "0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector2ic> VECTOR2I_CONVERTER = new IJavaWrapperConverter<Vector2ic>() {
    @Override
    public Vector2ic create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0);
    }

    @Override
    public String convert(Vector2ic it) {
      if(it!=null){int x=it.x();int y=it.y();return (x+";"+y);}return "0;0";
    }
  };

  private static final IJavaWrapperConverter<Vector2dc> VECTOR2D_CONVERTER = new IJavaWrapperConverter<Vector2dc>() {
    @Override
    public Vector2dc create(String it) {
      if(it!=null){final String[] split=it.split(";");if(split.length==2){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);return new org.joml.Vector2d(x,y);}}return new org.joml.Vector2d(0,0);
    }

    @Override
    public String convert(Vector2dc it) {
      if(it!=null){double x=it.x();double y=it.y();return (x+";"+y);}return "0;0";
    }
  };

  private TypesModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == TypesModelDefinition.Groups.MODEL_PART) return Optional.of((IFeaturedObject.Builder<T>) ModelPart.builder());
    else if (group == TypesModelDefinition.Groups.FLOAT_PARAMETER) return Optional.of((IFeaturedObject.Builder<T>) FloatParameter.builder());
    else if (group == TypesModelDefinition.Groups.STRING_PARAMETER) return Optional.of((IFeaturedObject.Builder<T>) StringParameter.builder());
    else if (group == TypesModelDefinition.Groups.BOOLEAN_PARAMETER) return Optional.of((IFeaturedObject.Builder<T>) BooleanParameter.builder());
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    if (enum_ == TypesModelDefinition.Enums.E_NOTIFICATION_DIRECTION) return (Optional<T>) Optional.of(ENotificationDirection.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_MOVE_STATE) return (Optional<T>) Optional.of(EMoveState.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_DIRECTION) return (Optional<T>) Optional.of(EDirection.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_TIME_UNIT) return (Optional<T>) Optional.of(ETimeUnit.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_NUMBER_COMPARISON_TYPE) return (Optional<T>) Optional.of(ENumberComparisonType.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_RELATIVE) return (Optional<T>) Optional.of(ERelative.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_VERTICAL_RELATIVE) return (Optional<T>) Optional.of(EVerticalRelative.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_HORIZONTAL_RELATIVE) return (Optional<T>) Optional.of(EHorizontalRelative.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_MOUSE_BUTTON) return (Optional<T>) Optional.of(EMouseButton.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_KEY_STATE) return (Optional<T>) Optional.of(EKeyState.valueOf(value));
    else if (enum_ == TypesModelDefinition.Enums.E_CHAR_TABLE) return (Optional<T>) Optional.of(ECharTable.valueOf(value));
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    if (wrapper == TypesModelDefinition.JavaWrappers.VECTOR4D) return Optional.of((IJavaWrapperConverter<T>) VECTOR4D_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.VECTOR4F) return Optional.of((IJavaWrapperConverter<T>) VECTOR4F_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.VECTOR4I) return Optional.of((IJavaWrapperConverter<T>) VECTOR4I_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.COLOR4F) return Optional.of((IJavaWrapperConverter<T>) COLOR4F_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.COLOR3F) return Optional.of((IJavaWrapperConverter<T>) COLOR3F_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.VECTOR3D) return Optional.of((IJavaWrapperConverter<T>) VECTOR3D_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.VECTOR3F) return Optional.of((IJavaWrapperConverter<T>) VECTOR3F_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.VECTOR3I) return Optional.of((IJavaWrapperConverter<T>) VECTOR3I_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.VECTOR2F) return Optional.of((IJavaWrapperConverter<T>) VECTOR2F_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.VECTOR2I) return Optional.of((IJavaWrapperConverter<T>) VECTOR2I_CONVERTER);
    else if (wrapper == TypesModelDefinition.JavaWrappers.VECTOR2D) return Optional.of((IJavaWrapperConverter<T>) VECTOR2D_CONVERTER);
    return Optional.empty();
  }
}
