package org.sheepy.lily.core.allocation.test.testallocation;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.allocation.test.testallocation.builder.BoxBuilder;
import org.sheepy.lily.core.allocation.test.testallocation.builder.ContainerBuilder;
import org.sheepy.lily.core.allocation.test.testallocation.builder.LeafBuilder;
import org.sheepy.lily.core.allocation.test.testallocation.builder.NodeBuilder;
import org.sheepy.lily.core.allocation.test.testallocation.builder.RootBuilder;

public interface TestallocationModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<AllocationObject> ALLOCATION_OBJECT = new GroupBuilder<AllocationObject>().name("AllocationObject").addFeatures(AllocationObject.Features.ALL).build();
    Group<Root> ROOT = new GroupBuilder<Root>().name("Root").concrete(true).addInclude(() -> new IncludeBuilder<AllocationObject>().group(() -> ALLOCATION_OBJECT).build()).addFeatures(Root.Features.ALL).lmBuilder(new BuilderSupplier<>(RootBuilder::new)).build();
    Group<Node> NODE = new GroupBuilder<Node>().name("Node").concrete(true).addInclude(() -> new IncludeBuilder<AllocationObject>().group(() -> ALLOCATION_OBJECT).build()).addFeatures(Node.Features.ALL).lmBuilder(new BuilderSupplier<>(NodeBuilder::new)).build();
    Group<Container> CONTAINER = new GroupBuilder<Container>().name("Container").concrete(true).addInclude(() -> new IncludeBuilder<AllocationObject>().group(() -> ALLOCATION_OBJECT).build()).addFeatures(Container.Features.ALL).lmBuilder(new BuilderSupplier<>(ContainerBuilder::new)).build();
    Group<Leaf> LEAF = new GroupBuilder<Leaf>().name("Leaf").concrete(true).addInclude(() -> new IncludeBuilder<AllocationObject>().group(() -> ALLOCATION_OBJECT).build()).addFeatures(Leaf.Features.ALL).lmBuilder(new BuilderSupplier<>(LeafBuilder::new)).build();
    Group<Box> BOX = new GroupBuilder<Box>().name("Box").concrete(true).addInclude(() -> new IncludeBuilder<AllocationObject>().group(() -> ALLOCATION_OBJECT).build()).addFeatures(Box.Features.ALL).lmBuilder(new BuilderSupplier<>(BoxBuilder::new)).build();
    List<Group<?>> ALL = List.of(ALLOCATION_OBJECT, ROOT, NODE, CONTAINER, LEAF, BOX);
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
