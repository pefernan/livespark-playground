/*
 * Copyright (C) 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package demo.client.local;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.ioc.client.api.ManagedInstance;
import org.livespark.flow.api.AppFlow;
import org.livespark.flow.api.Command;
import org.livespark.flow.api.CrudOperation;
import org.livespark.flow.api.Step;
import org.livespark.flow.api.Unit;
import org.livespark.flow.cdi.api.ForEntity;
import org.livespark.flow.client.local.CDIStepFactory;
import org.livespark.formmodeler.rendering.client.view.FlowProducer;
import org.livespark.formmodeler.rendering.client.view.StandaloneFormWrapper;

import demo.client.shared.Address;
import demo.client.shared.AddressFormModel;
import demo.client.shared.AddressRestService;

@Singleton
public class AddressFlowProducer extends FlowProducer<Address, AddressFormModel> {

    @Inject
    private Caller<AddressRestService> addressService;

    @Inject
    private CDIStepFactory stepFactory;

    @Inject
    private ManagedInstance<AddressListView> listViewProvider;

    @Inject
    private Event<IsElement> event;

    @Inject
    private ManagedInstance<StandaloneFormWrapper<Address, AddressFormModel, AddressFormView>> wrapperProvider;

    @Inject
    private ManagedInstance<AddressFormView> formProvider;

    @Produces
    @Singleton
    public Class<Address> entityType() {
        return Address.class;
    }

    @Override
    @Produces
    @ForEntity( "demo.client.shared.Address" )
    @Named( "crud" )
    @Singleton
    public AppFlow<Unit, Unit> crudFlow() {
        return super.crudFlow();
    }

    @Override
    @Produces
    @ForEntity( "demo.client.shared.Address" )
    @Named( "create" )
    @Singleton
    public AppFlow<Unit, Optional<AddressFormModel>> createFlow() {
        return super.createFlow();
    }

    @Override
    @Produces
    @ForEntity( "demo.client.shared.Address" )
    @Named( "createAndReview" )
    @Singleton
    public AppFlow<Unit, Unit> createAndReviewFlow() {
        return super.createAndReviewFlow();
    }

    @Override
    @Produces
    @ForEntity( "demo.client.shared.Address" )
    @Named( "view" )
    @Singleton
    public AppFlow<Unit, Unit> viewFlow() {
        return super.viewFlow();
    }

    @Override
    public Step<Address, Address> save() {
        return new Step<Address, Address>() {

            @Override
            public void execute( final Address input, final Consumer<Address> callback ) {
                addressService
                    .call( (final Address result) -> callback.accept( result ) )
                    .create( input );
            }

            @Override
            public String getName() {
                return "AddressSaver";
            }
        };
    }

    @Override
    public Step<Address, Address> update() {
        return new Step<Address, Address>() {

            @Override
            public void execute( final Address input, final Consumer<Address> callback ) {
                addressService
                    .call( result -> callback.accept( input ) )
                    .update( input );
            }

            @Override
            public String getName() {
                return "AddressUpdater";
            }
        };
    }

    @Override
    public Step<Address, Address> delete() {
        return new Step<Address, Address>() {

            @Override
            public void execute( final Address input, final Consumer<Address> callback ) {
                addressService
                    .call( result -> callback.accept( input ) )
                    .delete( input );
            }

            @Override
            public String getName() {
                return "AddressDeleter";
            }
        };
    }

    @Override
    public Step<Unit, List<Address>> load() {
        return new Step<Unit, List<Address>>() {

            @Override
            public void execute( final Unit input,
                                 final Consumer<List<Address>> callback ) {
                addressService
                    .call( (final List<Address> result) -> callback.accept( result ) )
                    .load();
            }

            @Override
            public String getName() {
                return "AddressLoader";
            }
        };
    }

    @Override
    public Step<List<Address>, Command<CrudOperation, Address>> listView( final boolean allowCreate, final boolean allowEdit, final boolean allowDelete ) {
        return stepFactory
                .createCdiStep( () -> listViewProvider.get(),
                                view -> {
                                    view.setAllowCreate( allowCreate );
                                    view.setAllowEdit( allowEdit );
                                    view.setAllowDelete( allowDelete );
                                    view.init();
                                    event.fire( view );
                                },
                                view -> {
                                    view.getElement().getParentElement().removeChild( view.getElement() );
                                    listViewProvider.destroy( view );
                                },
                                "AddressList" );
    }

    @Override
    public Step<AddressFormModel, Optional<AddressFormModel>> formView() {
        return stepFactory
                .createCdiStep( () -> {
                                    final StandaloneFormWrapper<Address, AddressFormModel, AddressFormView> wrapper = wrapperProvider.get();
                                    final AddressFormView form = formProvider.get();
                                    wrapper.setFormView( form );

                                    return wrapper;
                                },
                                view -> {
                                    view.init();
                                    event.fire( view );
                                },
                                view -> {
                                    view.getElement().getParentElement().removeChild( view.getElement() );
                                    wrapperProvider.destroy( view );
                                    formProvider.destroy( view.getFormView() );
                                },
                                "AddressForm" );
    }

    @Override
    public AddressFormModel modelToFormModel( final Address model ) {
        return new AddressFormModel( model );
    }

    @Override
    public Address newModel() {
        return new Address();
    }

    @Override
    public Address formModelToModel( final AddressFormModel formModel ) {
        return formModel.getAddress();
    }

}
