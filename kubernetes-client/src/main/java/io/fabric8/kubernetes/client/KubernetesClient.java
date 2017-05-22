/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.storage.DoneableStorageClass;
import io.fabric8.kubernetes.api.storage.StorageClass;
import io.fabric8.kubernetes.api.storage.StorageClassList;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.kubernetes.client.dsl.internal.StorageClassOperationsImpl;

import java.io.InputStream;
import java.util.Collection;

public interface KubernetesClient extends Client {

  ExtensionsAPIGroupDSL extensions();

  AppsAPIGroupDSL apps();

  MixedOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus, Resource<ComponentStatus, DoneableComponentStatus>> componentstatuses();

  ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata,Boolean> load(InputStream is);

  ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(String s);

  NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(KubernetesResourceList list);

  NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(HasMetadata... items);

  NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(Collection<HasMetadata> items);

  <T extends HasMetadata> NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<T ,Boolean> resource(T is);

  NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata,Boolean> resource(String s);

  MixedOperation<Endpoints, EndpointsList, DoneableEndpoints, Resource<Endpoints, DoneableEndpoints>> endpoints();

  MixedOperation<Event, EventList, DoneableEvent, Resource<Event, DoneableEvent>> events();

  NonNamespaceOperation< Namespace, NamespaceList, DoneableNamespace, Resource<Namespace, DoneableNamespace>> namespaces();

  NonNamespaceOperation<Node, NodeList, DoneableNode, Resource<Node, DoneableNode>> nodes();

  NonNamespaceOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, Resource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes();

  MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, Resource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims();

  MixedOperation<Pod, PodList, DoneablePod, PodResource<Pod, DoneablePod>> pods();

  MixedOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScalableResource<ReplicationController, DoneableReplicationController>> replicationControllers();

  MixedOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, Resource<ResourceQuota, DoneableResourceQuota>> resourceQuotas();

  MixedOperation<Secret, SecretList, DoneableSecret, Resource<Secret, DoneableSecret>> secrets();

  MixedOperation<Service, ServiceList, DoneableService, Resource<Service, DoneableService>> services();

  MixedOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, Resource<ServiceAccount, DoneableServiceAccount>> serviceAccounts();

  KubernetesListMixedOperation lists();
  
  MixedOperation<ConfigMap, ConfigMapList, DoneableConfigMap, Resource<ConfigMap, DoneableConfigMap>> configMaps();

  MixedOperation<LimitRange, LimitRangeList, DoneableLimitRange, Resource<LimitRange, DoneableLimitRange>> limitRanges();
  
  MixedOperation<StorageClass, StorageClassList, DoneableStorageClass, Resource<StorageClass, DoneableStorageClass>> storageClasses();
}
