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

import demo.client.shared.User;
import demo.client.shared.UserFormModel;
import demo.client.shared.UserRestService;

@Singleton
public class UserFlowProducer extends FlowProducer<User, UserFormModel> {

    @Inject
    private Caller<UserRestService> addressService;

    @Inject
    private CDIStepFactory stepFactory;

    @Inject
    private ManagedInstance<UserListView> listViewProvider;

    @Inject
    private Event<IsElement> event;

    @Inject
    private ManagedInstance<StandaloneFormWrapper<User, UserFormModel, UserFormView>> wrapperProvider;

    @Inject
    private ManagedInstance<UserFormView> formProvider;

    @Produces
    @Singleton
    public Class<User> entityType() {
        return User.class;
    }

    @Override
    @Produces
    @ForEntity( "demo.client.shared.User" )
    @Named( "crud" )
    @Singleton
    public AppFlow<Unit, Unit> crudFlow() {
        return super.crudFlow();
    }

    @Override
    @Produces
    @ForEntity( "demo.client.shared.User" )
    @Named( "create" )
    @Singleton
    public AppFlow<Unit, Optional<UserFormModel>> createFlow() {
        return super.createFlow();
    }

    @Override
    @Produces
    @ForEntity( "demo.client.shared.User" )
    @Named( "createAndReview" )
    @Singleton
    public AppFlow<Unit, Unit> createAndReviewFlow() {
        return super.createAndReviewFlow();
    }

    @Override
    @Produces
    @ForEntity( "demo.client.shared.User" )
    @Named( "view" )
    @Singleton
    public AppFlow<Unit, Unit> viewFlow() {
        return super.viewFlow();
    }

    @Override
    public Step<User, User> save() {
        return new Step<User, User>() {

            @Override
            public void execute( final User input, final Consumer<User> callback ) {
                addressService
                    .call( (final User result) -> callback.accept( result ) )
                    .create( input );
            }

            @Override
            public String getName() {
                return "UserSaver";
            }
        };
    }

    @Override
    public Step<User, User> update() {
        return new Step<User, User>() {

            @Override
            public void execute( final User input, final Consumer<User> callback ) {
                addressService
                    .call( result -> callback.accept( input ) )
                    .update( input );
            }

            @Override
            public String getName() {
                return "UserUpdater";
            }
        };
    }

    @Override
    public Step<User, User> delete() {
        return new Step<User, User>() {

            @Override
            public void execute( final User input, final Consumer<User> callback ) {
                addressService
                    .call( result -> callback.accept( input ) )
                    .delete( input );
            }

            @Override
            public String getName() {
                return "UserDeleter";
            }
        };
    }

    @Override
    public Step<Unit, List<User>> load() {
        return new Step<Unit, List<User>>() {

            @Override
            public void execute( final Unit input,
                                 final Consumer<List<User>> callback ) {
                addressService
                    .call( (final List<User> result) -> callback.accept( result ) )
                    .load();
            }

            @Override
            public String getName() {
                return "UserLoader";
            }
        };
    }

    @Override
    public Step<List<User>, Command<CrudOperation, User>> listView( final boolean allowCreate, final boolean allowEdit, final boolean allowDelete ) {
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
                                "UserList" );
    }

    @Override
    public Step<UserFormModel, Optional<UserFormModel>> formView() {
        return stepFactory
                .createCdiStep( () -> {
                                    final StandaloneFormWrapper<User, UserFormModel, UserFormView> wrapper = wrapperProvider.get();
                                    final UserFormView form = formProvider.get();
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
                                "UserForm" );
    }

    @Override
    public UserFormModel modelToFormModel( final User model ) {
        return new UserFormModel( model );
    }

    @Override
    public User newModel() {
        return new User();
    }

    @Override
    public User formModelToModel( final UserFormModel formModel ) {
        return formModel.getUser();
    }

}
